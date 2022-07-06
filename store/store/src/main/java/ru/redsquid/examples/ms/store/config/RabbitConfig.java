package ru.redsquid.examples.ms.store.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.redsquid.examples.ms.accounting.queue.message.PaidEvent;
import ru.redsquid.examples.ms.store.mq.Constants;
import ru.redsquid.examples.ms.store.queue.message.AcceptationCommand;


@Configuration
public class RabbitConfig {

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(Constants.EXCHANGE);
    }

    @Bean
    Queue storeAcceptationCommandQueue() {
        return new Queue(Constants.ACCEPTATION_COMMAND_QUEUE, false);
    }

    @Bean
    Binding acceptationCommandQueueBinding(Queue storeAcceptationCommandQueue, DirectExchange exchange) {
        return BindingBuilder.bind(storeAcceptationCommandQueue).to(exchange).with(AcceptationCommand.KEY);
    }

    @Bean
    Queue accountingPaidEventQueue() {
        return new Queue(Constants.ACCOUNTING_PAID_EVENT_QUEUE, false);
    }

    @Bean
    Binding accountingPaidEventQueueBinding(Queue accountingPaidEventQueue, DirectExchange exchange) {
        return BindingBuilder.bind(accountingPaidEventQueue).to(exchange).with(PaidEvent.KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
