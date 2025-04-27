package com.example.jwtAuth.service;

import com.example.jwtAuth.model.Student;
import com.example.jwtAuth.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class StudentService {


    @Autowired
    private StudentRepo studentRepo;

    public Student saveStudent(Student student) {
        try {

            return studentRepo.save(student);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save student details : " + e.getMessage(), e);
        }


    }

    public void deleteStudent(Integer id) {
        try {
            Student student = studentRepo.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("student not found with id" + id));
            studentRepo.delete(student);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete student details : " + e.getMessage(), e);
        }
    }


    public List<Student> getAllStudent() {
        try {
            return studentRepo.findAll();
        } catch (Exception e) {
            // Optionally log the error
            System.err.println("Error fetching students: " + e.getMessage());
            throw new RuntimeException("Error fetching students", e);  // Throwing an unchecked exception
        }
    }

}
