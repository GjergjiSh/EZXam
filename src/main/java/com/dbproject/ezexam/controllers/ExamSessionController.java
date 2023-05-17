package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.entities.ExamSession;
import com.dbproject.ezexam.services.ExamSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/sessions/")
public class ExamSessionController {
    private final ExamSessionService examSessionService;

    @GetMapping("/")
    public ResponseEntity<List<ExamSession>> getExamSessions() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(examSessionService.getAllExamSessions());
    }
}
