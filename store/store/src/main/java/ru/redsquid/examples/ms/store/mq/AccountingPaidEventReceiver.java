package ru.redsquid.examples.ms.store.mq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.redsquid.examples.ms.accounting.queue.message.PaidEvent;
import ru.redsquid.examples.ms.store.service.StoreService;

@Slf4j
@Component
@RequiredArgsConstructor
class AccountingPaidEventReceiver {

    private final StoreService service;

    @RabbitListener(queues = Constants.ACCOUNTING_PAID_EVENT_QUEUE)
    public void receive(PaidEvent event) {
        log.trace("receive: PaidEvent: {}", event);
        //TODO set paid  in DB
    }
}
