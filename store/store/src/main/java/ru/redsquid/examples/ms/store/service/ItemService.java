package ru.redsquid.examples.ms.store.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.redsquid.examples.ms.store.constants.ItemSet;

import java.util.Set;

@Slf4j
@Service
public class ItemService {

    public Set<Long> findAllItems() {
        log.trace("findAllItems");
        return ItemSet.ITEMS;
    }

    public boolean doesAllExist(Set<Long> items) {
        return ItemSet.ITEMS.containsAll(items);
    }
}
