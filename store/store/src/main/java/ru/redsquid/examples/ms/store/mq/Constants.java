package ru.redsquid.examples.ms.store.mq;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    public static final String EXCHANGE = "ms_exchange";

    public static final String ACCEPTATION_COMMAND_QUEUE = "store_store_acceptation_command_queue";

    public static final String ACCOUNTING_PAID_EVENT_QUEUE = "store_accounting_paid_event_queue";
}
