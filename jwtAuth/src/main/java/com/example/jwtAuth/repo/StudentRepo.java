package com.example.jwtAuth.repo;

import com.example.jwtAuth.model.Student;
import com.example.jwtAuth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student , Integer> {
    Student findByName(String name);
}
