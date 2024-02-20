package com.deeRav.controller;

import com.deeRav.entity.Book;
import com.deeRav.entity.FilterType;
import com.deeRav.entity.Operator;
import com.deeRav.request.BookCreateRequest;
import com.deeRav.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody BookCreateRequest bookCreateRequest){
    return this.bookService.createBook(bookCreateRequest);

    }
    @GetMapping("/filter")
    public List<Book>filter(@RequestParam("filterBy") FilterType filterBy,
                            @RequestParam("operator")Operator operator,
                            @RequestParam("value")String value){

        return bookService.filter(filterBy,operator,value);

    }
}
