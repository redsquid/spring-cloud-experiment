package ru.redsquid.examples.ms.store.queue.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReadyEvent {

    public static final String KEY = "event.store.ready";

    private UUID orderId;
}
