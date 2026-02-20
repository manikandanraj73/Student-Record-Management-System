package com.example.StudentRecordManagementSystem.dto;

import com.example.StudentRecordManagementSystem.models.Student;

import lombok.Data;

@Data
public class UpdateRequest {
    private Student student;
    private String role;
}
