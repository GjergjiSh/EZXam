package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.entities.Exam;
import com.dbproject.ezexam.entities.Question;
import com.dbproject.ezexam.services.ExamService;
import com.dbproject.ezexam.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/exams")
public class ExamController {
    private final ExamService examService;
    private final QuestionService questionService;

//    @GetMapping("/")
//    public ResponseEntity<Object> getAllExams() {
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(examService.getAllExams());
//    }
//
//    @GetMapping("/id/{id}")
//    public ResponseEntity<Optional<Exam>> getExamById(@PathVariable Long id) {
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(examService.getExamById(id));
//    }
//
//    @PostMapping("/{examId}/questions/{questionId}")
//    public ResponseEntity<Object> addQuestionToExam(@PathVariable Long examId, @PathVariable Long questionId) {
//        Exam exam = examService.getExamById(examId).orElse(null);
//        Question question = questionService.getQuestionById(questionId).orElse(null);
//
//        if (exam == null || question == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//
//        exam.getQuestions().add(question);
//        examService.saveExam(exam);
//
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(exam);
//    }
//
//    @DeleteMapping("/{examId}/questions/{questionId}")
//    public ResponseEntity<Object> removeQuestionFromExam(@PathVariable Long examId, @PathVariable Long questionId) {
//        Exam exam = examService.getExamById(examId).orElse(null);
//        Question question = questionService.getQuestionById(questionId).orElse(null);
//
//        if (exam == null || question == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//
//        exam.getQuestions().remove(question);
//        examService.saveExam(exam);
//
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(exam);
//    }
}
