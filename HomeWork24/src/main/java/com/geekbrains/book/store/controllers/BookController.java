package com.geekbrains.book.store.controllers;

import com.geekbrains.book.store.entities.Book;
import com.geekbrains.book.store.repositories.specifications.BookSpecifications;
import com.geekbrains.book.store.services.BookService;
import com.geekbrains.book.store.utils.BookFilter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    @GetMapping
    public String showAllBooks(Model model,
                               @RequestParam(name = "p", defaultValue = "0") Integer pageIndex,
                               @RequestParam(required = false) MultiValueMap params
    ) {
        StringBuilder paramsLine=new StringBuilder("");
        BookFilter bookFilter = new BookFilter(params);
        Page<Book> page = bookService.findAll(bookFilter.getSpec(), pageIndex , 5);
        model.addAttribute("books", page);
        int totalPages = page.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(0, totalPages-1)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        try{
            LinkedList<String> paramMaxPrice=(LinkedList) params.get("maxPrice");
            if(paramMaxPrice==null){
                paramMaxPrice=new LinkedList<>();
                paramMaxPrice.add("");
            }else {
                paramsLine.append("&maxPrice=").append(paramMaxPrice.get(0));
            }

            model.addAttribute("maxPrice",paramMaxPrice.get(0));
            LinkedList<String> paramTitlePart=(LinkedList) params.get("titlePart");
            if(paramTitlePart==null){
                paramTitlePart=new LinkedList<>();
                paramTitlePart.add("");
            }else {
                paramsLine.append("&titlePart=").append(paramTitlePart.get(0));
            }
            model.addAttribute("titlePart",paramTitlePart.get(0));
            LinkedList<String> paramGenres=(LinkedList) params.get("genre");
            if (paramGenres == null) {
                paramGenres=new LinkedList<>();
            }else{
                for(String genre :paramGenres){
                    if(genre.equals("DETECTIVE")){
                        paramsLine.append("&genre=").append("DETECTIVE");
                    }
                    if(genre.equals("FANTASY")){
                        paramsLine.append("&genre=").append("FANTASY");
                    }
                    if(genre.equals("FANTASTIC")){
                        paramsLine.append("&genre=").append("FANTASTIC");
                    }
                }

            }
            model.addAttribute("paramGenres", paramGenres);
            model.addAttribute("paramsLine",paramsLine);

        }catch (Exception e){}

        return "store-page";
    }

    // Эта часть кода будет сильно скорректирована после темы Spring REST
    @GetMapping("/rest")
    @ResponseBody
    @CrossOrigin("*")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }
}
