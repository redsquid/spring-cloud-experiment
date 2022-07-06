package ru.redsquid.examples.ms.accounting.service;

import java.util.UUID;

public interface AccountingService {

    void createInvoice(UUID orderId, double total);

    void paid(UUID orderId);
}
