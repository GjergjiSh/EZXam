package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.services.ExamSessionService;
import com.dbproject.ezexam.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/sessions/")
public class ExamSessionController {
    private final ExamSessionService examSessionService;

    @GetMapping("/")
    public ResponseEntity<Object> getExamSessions() {
        return ResponseUtils.returnSuccess(
                examSessionService.getAllExamSessions()
        );
    }

    @GetMapping("/subject/{id}")
    // TODO add error handling
    public ResponseEntity<Object> getSubjectSessions(@PathVariable Long id) {
        return ResponseUtils.returnSuccess(
                examSessionService.getSubjectExamSessions(id)
        );
    }
}
