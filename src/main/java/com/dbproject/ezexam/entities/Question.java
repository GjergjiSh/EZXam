package com.dbproject.ezexam.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
@Table(name = "questions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "exams"})
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private float total_points;


    @ManyToMany(mappedBy = "questions")
    private List<Exam> exams;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", total_points=" + total_points +
                '}';
    }
}
