package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.services.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/exams")
public class ExamController {
    private final ExamService examService;

    @GetMapping("/")
    public ResponseEntity<Object> getAllExams() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(examService.getAllExams());
    }
}
