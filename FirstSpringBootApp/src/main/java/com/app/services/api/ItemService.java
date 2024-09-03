package com.app.services.api;

import com.app.dto.ItemDto;
import com.app.entity.Item;
import com.app.entity.Person;

import java.util.List;

public interface ItemService {

    public List<Item> getAllItems();
    public Item addItem(ItemDto itemDto);
    public List<Item> getItemByPersonId(Long person);

}
