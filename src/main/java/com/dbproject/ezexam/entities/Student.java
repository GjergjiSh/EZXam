package com.dbproject.ezexam.entities;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(name = "name")
    private String name;

    // Add any other necessary fields, constructors, getters/setters, etc.
}