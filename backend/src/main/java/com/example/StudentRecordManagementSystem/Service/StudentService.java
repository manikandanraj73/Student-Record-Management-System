package com.example.StudentRecordManagementSystem.Service;

import com.example.StudentRecordManagementSystem.Repository.UserRepo;
import com.example.StudentRecordManagementSystem.models.Student;
import com.example.StudentRecordManagementSystem.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.StudentRecordManagementSystem.Repository.StudentRepo;

import java.util.List;


@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private UserRepo userRepo;


    public List<Student> ShowAllStudent() {
        return studentRepo.findAll();
    }

    public String addStudent(Student student) {
        studentRepo.save(student);
        return "Student Data Added";
    }

    public Student getStudentById(int no) {
        return studentRepo.findById(no).orElse(null);
    }

    public ResponseEntity<String> updateStudent(Student student,String role) {
        int no=student.getRno();
        if(studentRepo.existsById(no)){
        if(role.equals("teacher") || role.equals("admin")){
            studentRepo.save(student);
            return new ResponseEntity<>("Updated Successfully",HttpStatus.ACCEPTED);
        }
        else {return new ResponseEntity<>("Access Denied",HttpStatus.UNAUTHORIZED);}
        }
  return new ResponseEntity<>("Invalid Student Id",HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> deleteById(String role, int studentId) {

        Student student = studentRepo.findById(studentId).orElse(null);
        if (student == null) {
            return new ResponseEntity<>("Student Not Found", HttpStatus.NOT_FOUND);
        }
        if(role.equals("admin")){studentRepo.deleteById(studentId);
            return new ResponseEntity<>("Deleted",HttpStatus.ACCEPTED);}
        else {return new ResponseEntity<>("Access Denied",HttpStatus.UNAUTHORIZED);}
    }}
