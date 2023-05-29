package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.entities.ExamSession;
import com.dbproject.ezexam.entities.Subject;
import com.dbproject.ezexam.services.ExamService;
import com.dbproject.ezexam.services.ExamSessionService;
import com.dbproject.ezexam.services.SubjectService;
import com.dbproject.ezexam.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/sessions/")
public class ExamSessionController {
    private final ExamSessionService examSessionService;
    private final ExamService examService;

    @GetMapping("/")
    public ResponseEntity<Object> getExamSessions() {
        return ResponseUtils.returnSuccess(
                examSessionService.getAllExamSessions()
        );
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<Object> getSubjectSessions(@PathVariable Long id) {
        return ResponseUtils.returnSuccess(
                examSessionService.getSubjectExamSessions(id)
        );
    }
}
