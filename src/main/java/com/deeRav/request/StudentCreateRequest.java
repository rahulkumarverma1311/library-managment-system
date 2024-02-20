package com.deeRav.request;

import com.deeRav.entity.Student;
import com.deeRav.entity.StudentType;
import jakarta.persistence.Column;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCreateRequest {

    private String name;

    private String email;

    private String phoneNumber;

    private String address;


    public Student toBuilder() {
        return Student.builder()
                .name(this.name)
                .email(this.email)
                .phoneNumber(this.phoneNumber)
                .address(this.address)
                .status(StudentType.ACTIVE)
                .build();
    }
}
