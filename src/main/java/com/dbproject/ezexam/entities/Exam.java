package com.dbproject.ezexam.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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
    private ExamSession examSession;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

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
