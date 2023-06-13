package com.dbproject.ezexam.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class ExamSessionAnalysis {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "exam_session_id")
    @OneToOne
    private ExamSession examSession;

    @Column
    private int numberOfParticipants;

    @Column
    private double averageGrade;

    @Column
    private double highestGrade;

    @Column
    private int pass;

    @Column
    private int fail;
}


