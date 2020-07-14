package com.kostandov.geekbrains.homework12.main;

import com.kostandov.geekbrains.homework12.entitys.Book;
import com.kostandov.geekbrains.homework12.repository.ReflectionRepository;



public class Main {
    public static void main(String[] args) {
        ReflectionRepository<Book> reflectionRepository=new ReflectionRepository<>(Book.class);
        reflectionRepository.save(new Book("Remark","Three Friends",100));
        reflectionRepository.save(new Book("Artur Konan Doyl","Sherlock Holmes",150));
        reflectionRepository.save(new Book("Abovyan","Anush",200));
        Book book=reflectionRepository.findById(23l);
        System.out.println(book);
        System.out.println(reflectionRepository.findAll());

    }
}
