package com.example.StudentRecordManagementSystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class User {
    @Id
    @Column(length = 25)
    private int rno;
    @Column(length = 50)
    private String Username;
    @Column(length = 25)
    private String password;
    @Column(length = 25)
    private String role;

    public User() {
    }
}
