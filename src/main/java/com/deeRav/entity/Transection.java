package com.deeRav.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String transectionId;

    @ManyToOne
    @JoinColumn
    private Student student;

    @ManyToOne
    @JoinColumn
    private Book book;

    private int paindAmount;

    @CreationTimestamp
    private Date createOn;
    @UpdateTimestamp
    private Date updatedTime;
    @Enumerated(value = EnumType.STRING)
    private TransectionStatus transectionStatus;



}
