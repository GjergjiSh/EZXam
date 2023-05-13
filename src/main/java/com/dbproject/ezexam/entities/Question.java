package com.dbproject.ezexam.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

@Getter
@Table(name = "questions")
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    @NotBlank
    @Size(max = 256)
    private String description;

    @Column(name = "text")
    @NotBlank
    private String text;

    @Column(name = "points")
    @NotBlank
    private double points;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @OneToMany(mappedBy = "question")
    private List<Criteria> criterias;

    // other attributes

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", text='" + text + '\'' +
                ", points=" + points +
                ", topic=" + topic +
                ", criterias=" + criterias +
                '}';
    }


}

