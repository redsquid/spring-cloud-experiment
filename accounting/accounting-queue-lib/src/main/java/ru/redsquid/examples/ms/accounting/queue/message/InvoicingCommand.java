package ru.redsquid.examples.ms.accounting.queue.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoicingCommand {

    public static final String KEY = "command.accounting.invoicing";

    private UUID orderId;

    private Double total;
}
