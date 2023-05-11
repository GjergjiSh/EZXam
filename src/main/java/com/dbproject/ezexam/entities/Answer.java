package com.dbproject.ezexam.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "question_answers")
@Getter
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exam_result_id")
    private ExamResult examResult;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "max_points")
    private float maxPoints;

    @Column(name = "achieved_points")
    @Setter
    private float achievedPoints;

    @Column(name = "professor_notes")
    @Setter
    private String professorNotes;

    public Answer(ExamResult examResult,
                  String questionText,
                  String professorNotes,
                  float maxPoints,
                  float achievedPoints) {
         this.examResult = examResult;
         this.questionText = questionText;
         this.professorNotes = professorNotes;
         this.maxPoints = maxPoints;
         this.achievedPoints = achievedPoints;
    }


    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", examResult=" + examResult +
                ", questionText='" + questionText + '\'' +
                ", maxPoints=" + maxPoints +
                ", achievedPoints=" + achievedPoints +
                ", professorNotes='" + professorNotes + '\'' +
                '}';
    }
}