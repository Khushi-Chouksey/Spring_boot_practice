package com.example.jwtAuth.contoller;


import com.example.jwtAuth.model.Student;
import com.example.jwtAuth.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //adding student



     @PostMapping("/add")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

       Student saveStudent=  studentService.saveStudent(student);


       return new ResponseEntity<>(saveStudent , HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
         studentService.deleteStudent(id);
         return ResponseEntity.ok("Student deleted successfully");
    }

    @GetMapping("/getStudents")

    public List<Student> getAllStudents(){
        return studentService.getAllStudent();

    }



}
