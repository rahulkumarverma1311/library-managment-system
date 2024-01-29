package com.deeRav.service;

import com.deeRav.entity.Author;
import com.deeRav.entity.Book;
import com.deeRav.repository.AuthorRepo;
import com.deeRav.repository.BookRepo;
import com.deeRav.request.BookCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
