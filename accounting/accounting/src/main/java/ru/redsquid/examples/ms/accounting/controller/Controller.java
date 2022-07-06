package ru.redsquid.examples.ms.accounting.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.redsquid.examples.ms.accounting.service.AccountingService;

import java.util.UUID;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "ms/accounting/")
@Api(tags = "Accounting service")
@RequiredArgsConstructor
public class Controller {

    private final AccountingService service;

    @PostMapping("/order-{orderId}/paid")
    @ApiOperation(value = "Payment notification method")
    public void paid(@ApiParam("Order id (UUID)") @PathVariable UUID orderId) {
        service.paid(orderId);
    }
}
