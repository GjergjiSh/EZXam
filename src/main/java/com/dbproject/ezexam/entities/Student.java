package com.dbproject.ezexam.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String name;

    @Getter
    @Column(name = "matnr", unique = true)
    @NotBlank
    private String matnr;

    @Getter
    @Column(name = "lastname")
    @NotBlank
    private String lastname;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", matnr='" + matnr + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }


    // Add any other necessary fields, constructors, getters/setters, etc.
}