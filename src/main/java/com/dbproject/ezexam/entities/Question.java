package com.dbproject.ezexam.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
    @JoinColumn(name = "topic_id")
    @JsonBackReference("questionTopic")
    @NotBlank
    private Topic topic;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("questionCriterias")
    private List<Criteria> criterias;

    public void addCriteria(Criteria criteria) {
        criterias.add(criteria);
    }

    public void removeCriteria(Criteria criteria) {
        criterias.remove(criteria);
    }

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

