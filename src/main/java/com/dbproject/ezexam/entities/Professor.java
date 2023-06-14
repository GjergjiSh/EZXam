package com.dbproject.ezexam.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Table(name = "professors")
@Entity
@Setter
public class Professor {
    public Professor(String name, String lastname, User user){
        this.name = name;
        this.lastname = lastname;
        this.user = user;
    }
    public Professor(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank
    private String name;
    @Column(name = "lastname")
    @NotBlank
    private String lastname;


    @OneToOne
    @JoinColumn(name = "user_id")
    @NotBlank
    @JsonManagedReference("professorUser")
    private User user;


    @OneToMany(mappedBy = "professor")
    @JsonManagedReference("professorSubjects")
    private List<Subject> subjects;

    public void addSubject(Subject subject) {
        this.getSubjects().add(subject);
    }

    public void removeSubject(Subject subject) {
        this.getSubjects().remove(subject);
    }

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