package ru.redsquid.examples.ms.store.service;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public interface StoreService {

    void accept(UUID orderId, Set<Long> items);

    void start(UUID orderId);

    void ready(UUID orderId);
}
