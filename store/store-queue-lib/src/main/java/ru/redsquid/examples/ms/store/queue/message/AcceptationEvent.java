package ru.redsquid.examples.ms.store.queue.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcceptationEvent {

    public static final String KEY = "event.store.acceptation";

    private UUID orderId;

    private boolean accepted;
}
