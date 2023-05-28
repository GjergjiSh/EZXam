package com.dbproject.ezexam.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "criterias")
@NoArgsConstructor
public class Criteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // other attributes

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonBackReference("questionCriteria")
    private Question question;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "description")
    @NotBlank
    private String description;

    @Column(name = "weight")
    @NotBlank
    private double weight;

    public Criteria(String name, String description, double weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "id=" + id +
                ", question=" + question +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                '}';
    }


    // getters and setters
}
