package ru.redsquid.examples.ms.order.service.impl;

import brave.ScopedSpan;
import brave.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.redsquid.examples.ms.order.client.Notification;
import ru.redsquid.examples.ms.order.client.NotificationClient;
import ru.redsquid.examples.ms.order.dto.OrderDTO;
import ru.redsquid.examples.ms.order.entity.Order;
import ru.redsquid.examples.ms.order.mapper.OrderMapper;
import ru.redsquid.examples.ms.order.mq.sender.Sender;
import ru.redsquid.examples.ms.order.repository.OrderRepository;
import ru.redsquid.examples.ms.order.service.OrderService;
import ru.redsquid.examples.ms.store.queue.message.AcceptationCommand;

import java.util.UUID;

import static ru.redsquid.examples.ms.order.entity.Order.State.*;

@Slf4j
@Service
@RequiredArgsConstructor
class OrderServiceImpl implements OrderService {

    private final OrderMapper mapper;

    private final OrderRepository repo;

    private final StateChecker checker;

    private final Sender sender;

    private final NotificationClient notificationClient;

    private final Tracer tracer;

    public UUID create(OrderDTO dto) {
        log.trace("create: dto = {}", dto);
        Order order = mapper.orderDTOToOrder(dto);
        order.setState(PENDING);

        Order saved = null;
        ScopedSpan span = tracer.startScopedSpan("createOrderInPostgre");
        try {
            saved = repo.save(order);
        } finally {
            span.tag("peer.service", "postgre");
            span.annotate("Order created");
            span.finish();
        }

        AcceptationCommand command = mapper.orderToCommand(order);
        sender.send(command, AcceptationCommand.KEY);
        return saved.getId();
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void updateAcceptationState(UUID orderId, boolean accepted) {
        log.trace("update to Acceptation state: orderId = {}, accepted = {}", orderId, accepted);
        Order order = repo.findById(orderId).orElseThrow();
        Order.State state = accepted ? CREATED : DECLINE;
        if (checker.isAvailable(order, state)) {
            order.setState(state);
            repo.save(order);
        }
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void updateInvoicedState(UUID orderId) {
        log.trace("update to Invoiced state: orderId = {}", orderId);
        Order order = repo.findById(orderId).orElseThrow();
        if (checker.isAvailable(order, INVOICED)) {
            order.setState(INVOICED);
            repo.save(order);
        }
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void updatePaidState(UUID orderId) {
        log.trace("update to Paid state: orderId = {}", orderId);
        Order order = repo.findById(orderId).orElseThrow();
        if (checker.isAvailable(order, PAID)) {
            order.setState(PAID);
            repo.save(order);
        }
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void updateInProgressState(UUID orderId) {
        log.trace("update to InProgress state: orderId = {}", orderId);
        Order order = repo.findById(orderId).orElseThrow();
        if (checker.isAvailable(order, IN_PROGRESS)) {
            order.setState(IN_PROGRESS);
            repo.save(order);
        }
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void updateReadyState(UUID orderId) {
        log.trace("update to Ready state: orderId = {}", orderId);
        Order order = repo.findById(orderId).orElseThrow();
        if (checker.isAvailable(order, READY)) {
            order.setState(READY);
            repo.save(order);
            if (Boolean.TRUE.equals(order.getNotification())) {
                notificationClient.sendSms(new Notification(order.getCustomer().getPhone(), "ORDER READY"));
            }
        }
    }

    public void sendNotification(UUID orderId, String message) {
        log.trace("send notification: orderId = {}, message = {}", orderId, message);
        Order order = repo.findById(orderId).orElseThrow();
        notificationClient.sendSms(new Notification(order.getCustomer().getPhone(), message));
    }
}
