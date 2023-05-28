package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.entities.Criteria;
import com.dbproject.ezexam.entities.Question;
import com.dbproject.ezexam.services.CriteriaService;
import com.dbproject.ezexam.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/questions")
public class QuestionController {
    private final QuestionService questionService;
    private final CriteriaService criteriaService;

    @GetMapping("/")
    public ResponseEntity<Object> getQuestions() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(questionService.getAllQuestions());
    }

    @PostMapping("/subject/{subjectId}")
    public ResponseEntity<Object> addQuestion(@PathVariable Long subjectId, @RequestBody Question question) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(questionService.getAllQuestions());
    }

    @PutMapping("/{questionId}/criteria/")
    public ResponseEntity<Object> addCriteria(@PathVariable Long questionId,
                                              @RequestParam String name,
                                              @RequestParam String description,
                                              @RequestParam double weight) {
        try {
            Question question = questionService.getQuestionById(questionId);
            Criteria criteria = new Criteria(name, description, weight);
            questionService.addCriteriaToQuestion(question, criteria);
            criteriaService.saveCriteria(criteria);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(question);

        } catch (NoSuchElementException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(e.getMessage());

        }
    }
}
