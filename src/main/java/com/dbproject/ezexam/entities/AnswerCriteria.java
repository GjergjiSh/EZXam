package com.dbproject.ezexam.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table(name = "answer_criterias")
@Entity
public class AnswerCriteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    @JsonBackReference
    private Answer answer;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    private double weight;

    @Column(name = "met")
    private boolean met;

    // other attributes and relationships

    @Override
    public String toString() {
        return "AnswerCriteria{" +
                "id=" + id +
                ", answer=" + answer +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", met=" + met +
                '}';
    }
}