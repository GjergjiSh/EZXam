package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.dtos.ExamDTO;
import com.dbproject.ezexam.dtos.UpdateExamDTO;
import com.dbproject.ezexam.entities.Exam;
import com.dbproject.ezexam.services.ExamService;
import com.dbproject.ezexam.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/exams")
public class ExamController {
    private final ExamService examService;

    @GetMapping("/")
    public ResponseEntity<Object> getAllExams() {
        return ResponseUtils.returnSuccess(
                examService.getAllExams()
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Object> saveExam(@RequestBody UpdateExamDTO updateExamDTO) {
        return ResponseUtils.returnSuccess(examService.updateExam(updateExamDTO));
    }
}
