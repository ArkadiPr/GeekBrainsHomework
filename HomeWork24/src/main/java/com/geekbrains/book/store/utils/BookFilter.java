package com.geekbrains.book.store.utils;

import com.geekbrains.book.store.entities.Book;
import com.geekbrains.book.store.entities.BookGenre;
import com.geekbrains.book.store.repositories.specifications.BookSpecifications;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;

import java.util.LinkedList;
import java.util.Map;

@Getter
public class BookFilter {
    private Specification<Book> spec;
    private String filterParams;


    public BookFilter(MultiValueMap params) {
        spec = Specification.where(null);
        if (params.containsKey("maxPrice")) {
            LinkedList<String> filters=(LinkedList)params.get("maxPrice");
            String price=filters.get(0);
            if(!price.isEmpty()&&price!=null) {
                spec = spec.and(BookSpecifications.priceLesserOrEqualsThan(Integer.parseInt(price)));
            }
        }
        if (params.containsKey("titlePart")) {
            LinkedList<String> filters=(LinkedList<String>) params.get("titlePart");
            String title=filters.get(0);
            if(!title.isEmpty()&&title!=null) {
                spec = spec.and(BookSpecifications.titleLike(title));
            }
        }
        if(params.containsKey("genre")){
            LinkedList<String> filters=(LinkedList<String>) params.get("genre");
            for(String bookGenre:filters) {
                BookGenre currentGenre;
                switch (bookGenre){
                    case "FANTASY":
                        currentGenre=BookGenre.FANTASY;
                        break;
                    case "FANTASTIC":
                        currentGenre=BookGenre.FANTASTIC;
                        break;
                    default:
                        currentGenre=BookGenre.DETECTIVE;
                        break;
                }
                spec = spec.or(BookSpecifications.genreIs(currentGenre));
            }
        }

    }
}
