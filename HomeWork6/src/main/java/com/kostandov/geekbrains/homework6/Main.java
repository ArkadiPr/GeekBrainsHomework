package com.kostandov.geekbrains.homework6;

import com.kostandov.geekbrains.homework6.Task2.phonebook.PhoneBook;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    //Task 1.2
    public static Map<String,Integer> fromArrayToMap(String[] array){
        Map<String,Integer> result=new HashMap<>();
        for(String string : array){
            if(result.containsKey(string)){
                result.put(string,result.get(string)+1);
            }
            else {
                result.put(string,1);
            }
        }
        return result;
    }

    //Task 1.1
    public static Set<String> uniqueWords(String[] array){
        return fromArrayToMap(array).keySet();
    }


    public static void main(String[] args) {
        String[] capitals={"Moscow","Yerevan","Minsk","Tbilisi","Kishinev","London","Moscow",
                            "Astana","Tashkent","Yerevan","Riga","Astana","Moscow",
                            "Yerevan","Ashkhabad","Tbilisi","Kiev","Paris","Minsk","Madrid"};

        System.out.println(uniqueWords(capitals));
        System.out.println(fromArrayToMap(capitals));

        PhoneBook phoneBook=new PhoneBook();

        phoneBook.add("8 989 52 87 147","Ivanov");
        phoneBook.add("8 989 55 87 147","Petrov");
        phoneBook.add("8 989 52 87 257","Kalashnikov");
        phoneBook.add("8 999 55 67 147","Ivanov");

        System.out.println(phoneBook.get("Ivanov"));


    }
}
