package ru.redsquid.examples.ms.store.queue.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcceptationCommand {

    public static final String KEY = "command.store.acceptation";

    private UUID orderId;

    private Set<Long> items;
}
