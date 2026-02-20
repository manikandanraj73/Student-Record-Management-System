package com.example.StudentRecordManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.StudentRecordManagementSystem.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(nativeQuery = true,value = "select * from user where username=:username and password=:password")
    User findByUnameAndPass(String username, String password);
}
