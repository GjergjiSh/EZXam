package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.entities.Exam;
import com.dbproject.ezexam.entities.ExamSession;
import com.dbproject.ezexam.entities.Student;
import com.dbproject.ezexam.entities.Subject;
import com.dbproject.ezexam.services.ExamService;
import com.dbproject.ezexam.services.ExamSessionService;
import com.dbproject.ezexam.services.StudentService;
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
    private final StudentService studentService;

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

    @PutMapping("/{id}/exams/")
    // TODO: Change the way the duration are set
    // TODO: This is also better handled transactionally
    // TODO: Check if the student is already assigned to an exam in this session
    // TODO - Question: Back vs Managed reference in student/exam? (see Student.java/Exam.java)
    public ResponseEntity<Object> startExamInSession(@PathVariable Long id,
                                                     @RequestParam String studentMatnr,
                                                     @RequestParam int duration) {
        try {
            ExamSession examSession = examSessionService.getExamSessionById(id);
            Student student = studentService.getStudentByMatnr(studentMatnr);
            Exam exam = new Exam(examSession, student, duration);

            examSessionService.assignExam(examSession, exam);
            studentService.assignExam(student, exam);
            examService.saveExam(exam);

            System.out.println(exam);

            return ResponseUtils.returnSuccess(exam);
        } catch (NoSuchElementException e) {
            return ResponseUtils.returnNotFound(e.getMessage());
        }
    }

}
