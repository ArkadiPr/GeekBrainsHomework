package com.kostandov.geekbrains.homework23.controllers;

import com.kostandov.geekbrains.homework23.entitys.Item;
import com.kostandov.geekbrains.homework23.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ItemController {

    ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/allitems")
    public String getAllItems(Model model, @RequestParam(required = false) Long idItem) {
        model.addAttribute("items", itemService.requiredItems(idItem));
        return "all_items";
    }

    @PostMapping("/items/add")
    public String addNewItem(@ModelAttribute Item item) {
        itemService.saveItem(item);
        return "redirect:/allitems";
    }

    @GetMapping("/items/remove/{id}")
    public String removeItemById(@PathVariable Long id) {
        itemService.deleteById(id);
        return "redirect:/allitems";
    }

    @GetMapping("/item/edit/{id}")
    public String showEditItemForm(@PathVariable Long id, Model model) {
        model.addAttribute("item", itemService.getItem(id));
        return "item-edit-page";
    }

    @PostMapping("/item/edit")
    public String editItem(@ModelAttribute Item item) {
        itemService.saveOrUpdate(item);
        return "redirect:/allitems";
    }

}