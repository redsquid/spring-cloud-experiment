package ru.redsquid.examples.ms.accounting.queue.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaidEvent {

    public static final String KEY = "event.accounting.paid";

    private UUID orderId;
}
