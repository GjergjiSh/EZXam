package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.entities.Exam;
import com.dbproject.ezexam.entities.ExamSession;
import com.dbproject.ezexam.entities.Student;
import com.dbproject.ezexam.services.ExamService;
import com.dbproject.ezexam.services.ExamSessionService;
import com.dbproject.ezexam.services.StudentService;
import com.dbproject.ezexam.utils.ResponseUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSession(@PathVariable Long id) {
        return ResponseUtils.returnSuccess(
                examSessionService.getExamSession(id)
        );
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<Object> getSubjectSessions(@PathVariable Long id) {
        return ResponseUtils.returnSuccess(
                examSessionService.getSubjectExamSessions(id)
        );
    }

    @PutMapping("/finish/{id}")
    public ResponseEntity<Object> finishSession(@PathVariable Long id) {
        return ResponseUtils.returnSuccess(
                examSessionService.finishExamSession(id)
        );
    }

    @Transactional(rollbackOn = Exception.class)
    @PutMapping("/{id}/exams/")
    public ResponseEntity<Object> startExamInSession(@PathVariable Long id,
                                                     @RequestParam String studentMatnr,
                                                     @RequestParam int duration) {
        try {
            ExamSession examSession = examSessionService.getExamSessionById(id);
            Student student = studentService.getStudentByMatnr(studentMatnr);
            Optional<Exam> alreadyExistingExam = student.getExams().stream().filter(studentExam -> Objects.equals(studentExam.getExamSession().getId(), id)).findFirst();

            Exam exam = alreadyExistingExam.orElseGet(() -> new Exam(examSession, student, duration));

            examSessionService.assignExam(examSession, exam);
            studentService.assignExam(student, exam);
            Exam savedExam = examService.saveExam(exam);
            return ResponseUtils.returnSuccess(savedExam);
        } catch (NoSuchElementException e) {
            return ResponseUtils.returnNotFound(e.getMessage());
        }
    }

}
