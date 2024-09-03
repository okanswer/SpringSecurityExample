package com.app.services.impl;

import com.app.dto.ItemDto;
import com.app.entity.Item;
import com.app.entity.Person;
import com.app.repository.ItemRepository;
import com.app.repository.PersonRepository;
import com.app.services.api.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private final PersonRepository personRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item addItem(ItemDto itemDto) {
        Item item = new Item(itemDto.getId(),itemDto.getItemName(),personRepository.findById(itemDto.getPersonId()).get());
        itemRepository.save(item);
        return item;
    }

    @Override
    public List<Item> getItemByPersonId(Long personId) {
        return itemRepository.findItemByPersonId(personId);
    }
}
