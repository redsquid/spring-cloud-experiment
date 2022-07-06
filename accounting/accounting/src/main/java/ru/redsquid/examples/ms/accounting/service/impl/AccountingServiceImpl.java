package ru.redsquid.examples.ms.accounting.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.redsquid.examples.ms.accounting.queue.message.InvoicingEvent;
import ru.redsquid.examples.ms.accounting.queue.message.PaidEvent;
import ru.redsquid.examples.ms.accounting.mq.Sender;
import ru.redsquid.examples.ms.accounting.service.AccountingService;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
class AccountingServiceImpl implements AccountingService {

    private final Sender sender;

    public void createInvoice(UUID orderId, double total) {
        log.trace("create invoice: orderId = {}", orderId);
        InvoicingEvent event = new InvoicingEvent(orderId);
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            log.trace("Exception when Thread.sleep(2): orderId = {}", orderId);
        }
        log.trace("send Invoicing event: orderId = {}", orderId);
        sender.send(event, InvoicingEvent.KEY);
    }

    public void paid(UUID orderId) {
        log.trace("paid: orderId = {}", orderId);
        PaidEvent event = new PaidEvent(orderId);
        log.trace("send Paid event: orderId = {}", orderId);
        sender.send(event, PaidEvent.KEY);
    }
}
