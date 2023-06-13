package com.dbproject.ezexam.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter
@Table(name = "answers")
@NoArgsConstructor
@Entity
public class Answer {

    public Answer(Exam exam, String question, String text, String description, double points, double achievedPoints) {
        this.exam = exam;
        this.question = question;
        this.text = text;
        this.description = description;
        this.points = points;
        this.achievedPoints = achievedPoints;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    @JsonBackReference("answerExam")
    private Exam exam;

    @Column(name = "question")
    private String question;

    @Column(name = "text")
    private String text;
    @Column(name = "description")
    private String description;

    @Column(name = "points")
    private double points;

    @Column(name = "achieved_points")
    private double achievedPoints;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL)
    @JsonManagedReference("answerCriterias")
    private List<AnswerCriteria> answerCriterias;

    public void setAnswerCriterias(List<AnswerCriteria> answerCriterias) {
        this.answerCriterias = answerCriterias;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", exam=" + exam +
                ", question=" + question +
                ", text='" + text + '\'' +
                ", description='" + description + '\'' +
                ", points=" + points +
                ", achievedPoints=" + achievedPoints +
                '}';
    }
}





