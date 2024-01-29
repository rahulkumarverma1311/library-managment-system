package com.deeRav.request;

import com.deeRav.entity.Author;
import com.deeRav.entity.Book;
import com.deeRav.entity.BookType;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateRequest {

    private String name;

    private String bookNo;

    private int cost;

    private BookType type;

    private String authorName;

    private String authorEmail;

    public Author toAuthor(){
        return  Author.builder().
                name(this.authorName).
                email(this.authorEmail).build();
    }

    public Book toBook(){
        return Book.builder()
                .name(this.name)
                .bookNo(this.bookNo)
                .cost(this.cost)
                .type(this.type)
                .build();
    }
}
