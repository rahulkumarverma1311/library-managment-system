package com.deeRav.controller;

import com.deeRav.entity.Student;
import com.deeRav.request.StudentCreateRequest;
import com.deeRav.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/create")
    public Student createStudent(@RequestBody StudentCreateRequest studentCreateRequest){
        return this.studentService.createStudent(studentCreateRequest);

    }


}
