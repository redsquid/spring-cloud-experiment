package ru.redsquid.examples.ms.accounting.mq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.redsquid.examples.ms.accounting.queue.message.InvoicingCommand;
import ru.redsquid.examples.ms.accounting.service.AccountingService;

@Slf4j
@Component
@RequiredArgsConstructor
class InvoicingCommandReceiver {

    private final AccountingService service;

    @RabbitListener(queues = Constants.ACCOUNTING_INVOICING_COMMAND_QUEUE)
    public void receive(InvoicingCommand command) {
        log.trace("receive InvoicingCommand: command = {}", command);
        service.createInvoice(command.getOrderId(), command.getTotal());
    }
}
