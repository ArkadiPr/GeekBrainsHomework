package com.kostandov.geekbrains.homework12.entitys;

import com.kostandov.geekbrains.homework12.annotations.DbColumn;
import com.kostandov.geekbrains.homework12.annotations.DbId;
import com.kostandov.geekbrains.homework12.annotations.DbTable;

@DbTable(name="books")
public class Book {
    @DbId
    private Long id;
    @DbColumn
    private String author;
    @DbColumn
    private String name;

    @DbColumn
    private Integer pageNum;

    public Book(){

    }

    public Book(String author, String name, Integer pageNum) {
        this.author = author;
        this.name = name;
        this.pageNum = pageNum;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", pageNum=" + pageNum +
                '}';
    }
}
