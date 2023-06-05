package com.dbproject.ezexam.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "topics")
@Schema
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    @JsonBackReference("topicSubject")
    @NotBlank
    @JsonIgnore
    private Subject subject;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("topicQuestions")
    @Getter
    @Setter
    private List<Question> questions;

    public Topic(String name) {
        this.name = name;
    }

    public void addQuestion(Question question) {questions.add(question);}

    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject=" + subject +
                ", questions=" + questions +
                '}';
    }
}
