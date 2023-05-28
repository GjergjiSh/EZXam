package com.dbproject.ezexam.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "matnr", unique = true)
    @NotBlank
    private String matnr;

    @Column(name = "lastname")
    @NotBlank
    private String lastname;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference("studentExams")
    private List<Exam> exams;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", matnr='" + matnr + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}