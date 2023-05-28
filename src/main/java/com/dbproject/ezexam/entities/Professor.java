package com.dbproject.ezexam.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Table(name = "professors")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank
    private String name;
    @Column(name = "lastname")
    @NotBlank
    private String lastname;

    @OneToMany(mappedBy = "professor")
    @JsonManagedReference("professorSubjects")
    private List<Subject> subjects;

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}