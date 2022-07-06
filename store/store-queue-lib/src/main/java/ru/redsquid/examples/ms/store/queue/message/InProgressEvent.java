package ru.redsquid.examples.ms.store.queue.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InProgressEvent {

    public static final String KEY = "event.store.in_progress";

    private UUID orderId;
}
