package com.deeRav.service;

import com.deeRav.entity.Student;
import com.deeRav.repository.StudentRepo;
import com.deeRav.request.StudentCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    public Student createStudent(StudentCreateRequest studentCreateRequest){
        Student studentFromDB = this.studentRepo.findByPhoneNumber(studentCreateRequest.getPhoneNumber());
        if(studentFromDB == null){
          studentFromDB =this.studentRepo.save(studentCreateRequest.toBuilder());
        }
        return studentFromDB;

    }



}
