package com.kostandov.geekbrains.homework22.controllers;

import com.kostandov.geekbrains.homework22.entitys.Item;
import com.kostandov.geekbrains.homework22.entitys.User;
import com.kostandov.geekbrains.homework22.services.ItemService;
import com.kostandov.geekbrains.homework22.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String addNewBox(@ModelAttribute Item item) {
        itemService.saveItem(item);
        return "redirect:/allitems";
    }

}