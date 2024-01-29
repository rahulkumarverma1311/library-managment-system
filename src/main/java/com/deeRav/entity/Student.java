package com.deeRav.entity;

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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30)
    private String name;
    @Column(unique = true,length = 30)
    private String email;
    @Column(unique = true,length = 15,nullable = false)
    private String phoneNumber;

    private String address;
    @CreationTimestamp
    private Date createOn;
    @UpdateTimestamp
    private Date updatedTime;
    @Enumerated(value = EnumType.STRING)
    private StudentType status;
    @OneToMany(mappedBy = "student")
    private List<Book>books;
    @OneToMany(mappedBy = "student")
    private List<Transection> transections;

}
