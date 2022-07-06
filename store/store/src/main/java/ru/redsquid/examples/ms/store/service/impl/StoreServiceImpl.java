package ru.redsquid.examples.ms.store.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.redsquid.examples.ms.accounting.queue.message.InvoicingCommand;
import ru.redsquid.examples.ms.store.mq.Sender;
import ru.redsquid.examples.ms.store.queue.message.AcceptationEvent;
import ru.redsquid.examples.ms.store.queue.message.InProgressEvent;
import ru.redsquid.examples.ms.store.queue.message.ReadyEvent;
import ru.redsquid.examples.ms.store.service.ItemService;
import ru.redsquid.examples.ms.store.service.StoreService;

import java.util.Random;
import java.util.Set;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
class StoreServiceImpl implements StoreService {

    private final ItemService itemService;

    private final Random random = new Random();

    private final Sender sender;

    public void accept(UUID orderId, Set<Long> items) {
        log.trace("accept: orderId = {}", orderId);
        boolean accepted = itemService.doesAllExist(items);
        AcceptationEvent event = new AcceptationEvent(orderId, accepted);

        log.trace("send acceptation event: {}", orderId);
        sender.send(event, AcceptationEvent.KEY);

        if (accepted) {
            log.trace("send invoicing command: orderId = {}", orderId);
            InvoicingCommand command = new InvoicingCommand(orderId, calculate());
            sender.send(command, InvoicingCommand.KEY);
        }
    }

    public void start(UUID orderId) {
        log.trace("start: orderId = {}", orderId);
        InProgressEvent event = new InProgressEvent(orderId);
        log.trace("send InProgress event: orderId = {}", orderId);
        sender.send(event, InProgressEvent.KEY);
    }

    public void ready(UUID orderId) {
        log.trace("ready: orderId = {}", orderId);
        ReadyEvent event = new ReadyEvent(orderId);
        log.trace("send Ready event: orderId = {}", orderId);
        sender.send(event, ReadyEvent.KEY);
    }

    private synchronized double calculate() {
        return Math.round(random.nextDouble() * 100.) / 100.;
    }
}
