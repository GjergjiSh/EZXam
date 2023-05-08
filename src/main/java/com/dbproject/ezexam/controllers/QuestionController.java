package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}
