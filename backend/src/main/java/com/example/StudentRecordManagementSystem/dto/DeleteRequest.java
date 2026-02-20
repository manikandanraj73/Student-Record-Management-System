package com.example.StudentRecordManagementSystem.dto;

import lombok.Data;

@Data
public class DeleteRequest {
    private String role;
    private int studentId;
}
