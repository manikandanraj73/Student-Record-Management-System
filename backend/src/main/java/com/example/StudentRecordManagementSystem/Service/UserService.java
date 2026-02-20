package com.example.StudentRecordManagementSystem.Service;

import com.example.StudentRecordManagementSystem.Repository.UserRepo;
import com.example.StudentRecordManagementSystem.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public ResponseEntity<User> login(User user) {
        User u=userRepo.findByUnameAndPass(user.getUsername(),user.getPassword());
        if(u!=null){return ResponseEntity.ok(u);
    }return ResponseEntity.status(401).build();
}}
