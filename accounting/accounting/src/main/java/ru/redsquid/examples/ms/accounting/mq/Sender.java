package ru.redsquid.examples.ms.accounting.mq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Sender {

    private final RabbitTemplate rabbitTemplate;

    public void send(Object event, String key) {
        rabbitTemplate.convertAndSend(Constants.EXCHANGE, key, event);
    }
}
