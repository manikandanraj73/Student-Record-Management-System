package com.example.StudentRecordManagementSystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Student {
    @Id
    @Column(length = 25)
    private int rno;
    @Column(length = 50)
    private String sname;
    @Column(length = 25)
    private String dept;
    @Column(length = 50)
    private String email;
public Student(){}
}
