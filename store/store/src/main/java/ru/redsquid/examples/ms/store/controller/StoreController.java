package ru.redsquid.examples.ms.store.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.redsquid.examples.ms.store.service.StoreService;

import java.util.UUID;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "ms/store/")
@Api(tags = "Store service")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService service;

    @PostMapping("/order-{orderId}/start")
    @ApiOperation(value = "Order start notification method")
    public void start(@ApiParam("Order id (UUID)") @PathVariable UUID orderId) {
        service.start(orderId);
    }

    @PostMapping("/order-{orderId}/ready")
    @ApiOperation(value = "Order ready notification method")
    public void ready(@ApiParam("Order id (UUID)") @PathVariable UUID orderId) {
        service.ready(orderId);
    }
}
