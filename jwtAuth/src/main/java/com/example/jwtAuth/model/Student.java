package com.example.jwtAuth.model;


import jakarta.persistence.*;


@Entity
@Table(name = "student") // no need for backticks here unless table name is a keyword
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")  // match MySQL column exactly
    private int id;

    @Column(name = "name") // match MySQL column exactly
    private String name;

    @Column(name = "email") // match MySQL column exactly
    private String email;

    public Student() {
        // default constructor needed for Hibernate
    }

    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}