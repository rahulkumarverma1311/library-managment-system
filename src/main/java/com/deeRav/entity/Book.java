package com.deeRav.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30)
    private String name;
    private String bookNo;
    
    private int cost;
    @Enumerated
    private BookType type;

    @ManyToOne
    @JoinColumn
    private Student student;


    





}
