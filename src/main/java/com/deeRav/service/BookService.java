package com.deeRav.service;

import com.deeRav.entity.*;
import com.deeRav.repository.AuthorRepo;
import com.deeRav.repository.BookRepo;
import com.deeRav.request.BookCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    public Book createBook(BookCreateRequest bookCreateRequest){
        Author authorFromDb = this.authorRepo.findByEmail(bookCreateRequest.getAuthorEmail());
        if(authorFromDb == null){
            authorFromDb = this.authorRepo.save(bookCreateRequest.toAuthor());

        }
        Book book = bookCreateRequest.toBook();
        book.setAuthor(authorFromDb);
        return this.bookRepo.save(book);

    }

    public List<Book> filter(FilterType filterBy, Operator operator, String value) {

        switch (operator){
            case EQUALS:
                switch (filterBy){
                    case BOOK_NO:
                       return  bookRepo.findByBookNo(value);

                    case AUTHOR_NAME:
                       return  bookRepo.findByAuthorName(value);

                    case COST:
                       return bookRepo.findByCost(Integer.valueOf(value));

                    case BOOK_TYPE:
                       return bookRepo.findByType(BookType.valueOf(value));
                }
            case LESS_THAN:
                switch (filterBy){

                    case COST:
                        return bookRepo.findByCostLessThan(Integer.valueOf(value));

                }
            default:
                return new ArrayList<>();
        }


    }

    public void saveUpDateBook(Book book){
        bookRepo.save(book);
    }
}
