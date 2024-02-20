package com.deeRav.repository;

import com.deeRav.entity.Book;
import com.deeRav.entity.BookType;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface BookRepo extends JpaRepository<Book,Integer> {


    List<Book>findByBookNo(String bookNo);

    List<Book>findByAuthorName(String authorName);

    List<Book>findByCost(int cose);

    List<Book>findByType(BookType type);



    List<Book>findByCostLessThan(int cost);
}
