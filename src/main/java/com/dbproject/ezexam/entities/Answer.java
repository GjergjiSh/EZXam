package com.dbproject.ezexam.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Table(name = "answers")
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    @JsonBackReference("answerExam")
    private Exam exam;

    @Column(name = "text")
    private String text;

    @Column(name = "description")
    private String description;

    @Column(name = "points")
    private double points;

    @Column(name = "achieved_points")
    private double achievedPoints;

    @OneToMany(mappedBy = "answer")
    @JsonManagedReference("answerCriterias")
    private List<AnswerCriteria> answerCriterias;

    // other attributes and relationships

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", exam=" + exam +
                ", text='" + text + '\'' +
                ", description='" + description + '\'' +
                ", points=" + points +
                ", achievedPoints=" + achievedPoints +
                '}';
    }
}





