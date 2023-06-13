package com.dbproject.ezexam.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name = "answer_criterias")
@NoArgsConstructor
@Entity
public class AnswerCriteria {

    public AnswerCriteria(Answer answer, String name, String description, double weight, boolean met) {
        this.answer = answer;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.met = met;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    @JsonBackReference("criteriaAnswer")
    private Answer answer;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    private double weight;

    @Column(name = "met")
    private boolean met;

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