package com.kostandov.geekbrains.homework23.services;

import com.kostandov.geekbrains.homework23.entitys.Item;
import com.kostandov.geekbrains.homework23.exceptions.ResourceNotFoundException;
import com.kostandov.geekbrains.homework23.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
        return itemRepository.findById(itemId).orElseThrow(()->new ResourceNotFoundException());
    }

    public Iterable<Item> getItems(){
        return itemRepository.findAll();
    }

    public Iterable<Item> requiredItems(Long id){
        if(id==null){
            return getItems();
        }else {
            return Collections.singletonList(getItem(id));
        }
    }

    public void deleteById(Long id){
        itemRepository.deleteById(id);
    }
    public Item saveOrUpdate(Item item) {
        return itemRepository.save(item);
    }
}
