package ru.redsquid.examples.ms.accounting.mq;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    public static final String EXCHANGE = "ms_exchange";

    public static final String ACCOUNTING_INVOICING_COMMAND_QUEUE = "accounting_accounting_invoicing_command_queue";
}
