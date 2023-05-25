package com.dbproject.ezexam.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Table(name = "exam_sessions")
@Entity
public class ExamSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    @JsonBackReference("sessionSubject")
    private Subject subject;

    @OneToMany(mappedBy = "examSession")
    @JsonManagedReference("sessionExams")
    private List<Exam> exams;

    @Column(name = "finished")
    private Boolean finished;

    @Column(name = "date")
    @NotBlank
    private LocalDate date;
}
