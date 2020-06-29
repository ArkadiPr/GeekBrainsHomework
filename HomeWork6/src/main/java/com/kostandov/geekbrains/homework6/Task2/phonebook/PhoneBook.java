package com.kostandov.geekbrains.homework6.Task2.phonebook;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneBook {
    HashMap<String,String> phoneNumbers=new HashMap<>();

    public void add(String number,String name){
        phoneNumbers.put(number,name);
    }

    public Map<String,String> get(String name){
        return phoneNumbers.entrySet().stream().
                filter(e->e.getValue().equals(name)).
                collect(Collectors.toMap(entry->entry.getKey(),entry->entry.getValue()));
    }
}
