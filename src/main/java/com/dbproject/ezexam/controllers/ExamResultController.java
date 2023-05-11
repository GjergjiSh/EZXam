package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.entities.Answer;
import com.dbproject.ezexam.entities.Enrollment;
import com.dbproject.ezexam.entities.ExamResult;
import com.dbproject.ezexam.services.AnswerService;
import com.dbproject.ezexam.services.ExamResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/results")
@RequiredArgsConstructor
public class ExamResultController {

    private final ExamResultService examResultService;
    private final AnswerService answerService;

    @GetMapping("/")
    public ResponseEntity<Object> getExamResults() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(examResultService.getAllExamResults());
    }


    @PostMapping("/")
    public ResponseEntity<ExamResult> createExamResult(@RequestBody Enrollment enrollment) {
        ExamResult examResult = examResultService.createExamResult(enrollment);
        return ResponseEntity.ok(examResult);
    }

    @PostMapping("/results/{resultId}/answers")
    public ResponseEntity<ExamResult> addAnswerToExamResult(
            @PathVariable Long resultId,
            @RequestBody Map<String, Object> request) {

        Optional<ExamResult> examResult = examResultService.getExamResult(resultId);

        if (examResult.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        String questionText = request.get("questionText").toString();
        String professorNotes = request.get("professorNotes").toString();
        float maxPoints = Float.parseFloat(request.get("maxPoints").toString());
        float achievedPoints = Float.parseFloat(request.get("achievedPoints").toString());

        Answer answer = new Answer(
                examResult.get(),
                questionText,
                professorNotes,
                maxPoints,
                achievedPoints
        );

        examResult.get().addAnswer(answer);
        answerService.saveAnswer(answer);
        examResultService.createExamResult(examResult.get());

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(examResult.get());
    }
}