package com.deeRav.repository;

import com.deeRav.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {


    Student findByPhoneNumber(String phoneNumber);
}
