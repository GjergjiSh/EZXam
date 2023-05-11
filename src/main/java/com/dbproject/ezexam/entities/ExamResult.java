package com.dbproject.ezexam.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exam_results")
@NoArgsConstructor
public class ExamResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @Column(name = "exam_name")
    private String exam;

    @Column(name = "total_points_achieved")
    private int totalPointsAchieved;

    @Column(name = "final_grade")
    private String finalGrade;

    @OneToMany(mappedBy = "examResult", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

    //TODO: Missing questions

    public ExamResult(Enrollment enrollment) {
        this.student = enrollment.getStudent();
        this.professor = enrollment.getProfessor();
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
        this.totalPointsAchieved += answer.getAchievedPoints();
    }

    public void removeAnswer(Answer answer) {
        this.answers.remove(answer);
        this.totalPointsAchieved -= answer.getAchievedPoints();
    }

    @Override
    public String toString() {
        return "ExamResult{" +
                "id=" + id +
                ", student=" + student +
                ", professor=" + professor +
                ", exam='" + exam + '\'' +
                ", totalPointsAchieved=" + totalPointsAchieved +
                ", finalGrade='" + finalGrade + '\'' +
                ", answers=" + answers +
                '}';
    }
}
