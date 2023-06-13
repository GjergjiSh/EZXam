package com.dbproject.ezexam.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "exams")
@Entity
@NoArgsConstructor
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exam_session_id")
    @JsonBackReference("examSession")
    private ExamSession examSession;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference("examStudent")
    @NotBlank
    private Student student;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    @JsonManagedReference("examAnswers")
    private List<Answer> answers;

    @Column(name = "duration")
    private int duration;

    public Exam(ExamSession examSession, Student student, int duration) {
        this.examSession = examSession;
        this.student = student;
        this.answers = new ArrayList<>();
        this.duration = duration;
    }
    @Column(name = "grade")
    private double grade;

    // other attributes

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", examsession=" + examSession +
                ", student=" + student +
                '}';
    }
}
