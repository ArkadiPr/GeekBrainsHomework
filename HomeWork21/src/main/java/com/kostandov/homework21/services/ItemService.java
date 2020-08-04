package com.kostandov.homework21.services;

import com.kostandov.homework21.entitys.Item;
import com.kostandov.homework21.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item saveItem(Item item){
        return itemRepository.save(item);
    }

    public Item getItem(Long itemId){
        return itemRepository.loadById(itemId);
    }

    public List<Item> getItems(){
        return itemRepository.findAll();
    }
}
