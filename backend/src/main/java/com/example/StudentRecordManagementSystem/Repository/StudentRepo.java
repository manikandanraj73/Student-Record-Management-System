package com.example.StudentRecordManagementSystem.Repository;

import com.example.StudentRecordManagementSystem.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    @Query(nativeQuery = true,value = "select * from student where sname=:name")
    List<Student> findByName(String name);
}
