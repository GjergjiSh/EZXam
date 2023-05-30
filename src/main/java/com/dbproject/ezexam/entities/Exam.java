package com.dbproject.ezexam.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

@Getter
@Table(name = "exams")
@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exam_session_id")
    @JsonBackReference
    private ExamSession examSession;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    @NotBlank
    private Student student;

    @OneToMany(mappedBy = "exam")
    @JsonManagedReference
    private List<Answer> answers;

    @Column(name = "duration")
    private int duration;

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
