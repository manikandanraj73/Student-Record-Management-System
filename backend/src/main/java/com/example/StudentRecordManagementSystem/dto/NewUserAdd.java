package com.example.StudentRecordManagementSystem.dto;

import com.example.StudentRecordManagementSystem.models.User;
import lombok.Data;

@Data
public class NewUserAdd {
    private User user;
    private String role;

}
