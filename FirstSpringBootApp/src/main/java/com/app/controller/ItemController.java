package com.app.controller;

import com.app.dto.ItemDto;
import com.app.dto.PersonDto;
import com.app.entity.Item;
import com.app.entity.Person;
import com.app.services.api.ItemService;
import com.app.services.api.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ItemController {

    private ItemService itemService;

    @GetMapping("item/getItems")
    public Object getAllPerson(){
        return itemService.getAllItems();
    }

    @PostMapping("item/createItem")
    @ResponseBody
    public Item createPerson(@RequestBody ItemDto itemDto){
        return itemService.addItem(itemDto);
    }

    @GetMapping("item/getPersonItems")
    @ResponseBody
    public List<Item> getPersonItems(@RequestParam Long personId){
        return itemService.getItemByPersonId(personId);
    }
}
