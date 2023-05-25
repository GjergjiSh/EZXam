package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.entities.Question;
import com.dbproject.ezexam.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/questions")
public class QuestionController {
    private final QuestionService questionService;

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
}
