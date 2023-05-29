package com.dbproject.ezexam.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("subjectTopics")
    private List<Topic> topics;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    @JsonBackReference("professorSubjects")
    private Professor professor;

    @OneToMany(mappedBy = "subject")
    @JsonManagedReference("subjectSessions")
    private List<ExamSession> examSessions;

    public void addTopic(Topic topic) {
        this.getTopics().add(topic);
    }

    public void removeTopic(Topic topic) {
        this.getTopics().remove(topic);
    }

}