package ru.redsquid.examples.ms.store.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.redsquid.examples.ms.store.service.ItemService;

import java.util.Set;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "ms/store")
@Api(tags = "Item service")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;

    @GetMapping("/items")
    @ApiOperation(value = "Find all items")
    public Set<Long> find() {
        return service.findAllItems();
    }
}
