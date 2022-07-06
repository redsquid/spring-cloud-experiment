package ru.redsquid.examples.ms.accounting.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.redsquid.examples.ms.accounting.mq.Constants;
import ru.redsquid.examples.ms.accounting.queue.message.InvoicingCommand;


@Configuration
public class RabbitConfig {

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(Constants.EXCHANGE);
    }

    @Bean
    Queue invoicingCommandQueue() {
        return new Queue(Constants.ACCOUNTING_INVOICING_COMMAND_QUEUE, false);
    }

    @Bean
    Binding binding(Queue invoicingCommandQueue, DirectExchange exchange) {
        return BindingBuilder.bind(invoicingCommandQueue).to(exchange).with(InvoicingCommand.KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
