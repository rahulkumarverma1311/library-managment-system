package com.deeRav.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30)
    private String name;
    @Column(unique = true,length = 30,nullable = false)
    private String email;

    @CreationTimestamp
    private Date createOn;
    @UpdateTimestamp
    private Date updatedTime;
    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Book> bookList;



}
