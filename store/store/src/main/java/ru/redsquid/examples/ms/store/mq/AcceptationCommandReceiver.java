package ru.redsquid.examples.ms.store.mq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.redsquid.examples.ms.store.queue.message.AcceptationCommand;
import ru.redsquid.examples.ms.store.service.StoreService;

@Slf4j
@Component
@RequiredArgsConstructor
class AcceptationCommandReceiver {

    private final StoreService service;

    @RabbitListener(queues = Constants.ACCEPTATION_COMMAND_QUEUE)
    public void receive(AcceptationCommand command) {
        log.trace("receive AcceptationCommand: {}", command);
        service.accept(command.getOrderId(), command.getItems());
    }
}
