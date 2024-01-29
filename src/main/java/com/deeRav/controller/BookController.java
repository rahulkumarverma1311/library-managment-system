package com.deeRav.controller;

import com.deeRav.entity.Book;
import com.deeRav.request.BookCreateRequest;
import com.deeRav.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody BookCreateRequest bookCreateRequest){
    return this.bookService.createBook(bookCreateRequest);

    }
}
