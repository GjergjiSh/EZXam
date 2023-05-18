package com.dbproject.ezexam.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Table(name = "professors")
public class Professor {
    public Professor(String name, String lastname, User user){
        this.name = name;
        this.lastname = lastname;
        this.user = user;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "lastname")
    @NotBlank
    private String lastname;


    @OneToOne(mappedBy = "professor")
    @NotBlank
    private User user;


    @OneToMany(mappedBy = "professor")
    @JsonManagedReference
    private List<Subject> subjects;

    // other attributes

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