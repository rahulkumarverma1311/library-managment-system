package com.deeRav.repository;

import com.deeRav.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepo extends JpaRepository<Author,Integer> {
    // ist way to write the query
    @Query(value = "select * from author where email = :email",nativeQuery = true) // mysql run the query
    Author getAuthor(String email);


    // 2nd way of writing query

    @Query(value = "select a from Author a where a.email = :email") // hibernate run the query
    Author getAuthorWithAoutNative(String email);

    // 3rd way to write the query


    Author findByEmail(String email);




}
