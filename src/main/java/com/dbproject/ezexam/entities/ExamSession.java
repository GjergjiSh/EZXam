package com.dbproject.ezexam.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@Table(name = "exam_sessions")
@Entity
@NoArgsConstructor
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

    public ExamSession(Subject subject, List<Exam> exams, Boolean finished, LocalDate date) {
        this.subject = subject;
        this.exams = exams;
        this.finished = finished;
        this.date = date;
    }

    public void addExam(Exam exam) {
        this.exams.add(exam);
    }

    public void removeExam(Exam exam) {
        this.exams.remove(exam);
    }
}
