package com.example.StudentRecordManagementSystem.Controller;


import com.example.StudentRecordManagementSystem.dto.DeleteRequest;
import com.example.StudentRecordManagementSystem.dto.UpdateRequest;
import com.example.StudentRecordManagementSystem.models.User;
import com.example.StudentRecordManagementSystem.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.StudentRecordManagementSystem.Service.StudentService;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> showAllStudent(){
       return studentService.ShowAllStudent();
    }
    @PostMapping("/students")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @GetMapping("students/{rno}")
    public ResponseEntity<Student> getStudentById(@PathVariable("rno") int no){
         Student st=studentService.getStudentById(no);
         if(st==null){return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
         return new ResponseEntity<>(st,HttpStatus.OK);
}
    @PutMapping("students/update")
    public ResponseEntity<String> updateStudent(@RequestBody UpdateRequest updateRequest){
       return studentService.updateStudent(updateRequest.getStudent(), updateRequest.getRole());
    }
    @DeleteMapping("students/delete")
    public ResponseEntity<String> deleteStudent(@RequestBody DeleteRequest deleteRequest){
            return studentService.deleteById(deleteRequest.getRole(),deleteRequest.getStudentId());
        }

   }
