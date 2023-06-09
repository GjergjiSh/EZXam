package com.dbproject.ezexam.services;

import com.dbproject.ezexam.entities.Exam;
import com.dbproject.ezexam.entities.ExamSession;
import com.dbproject.ezexam.entities.Subject;
import com.dbproject.ezexam.repositories.ExamSessionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ExamSessionService {
    private final ExamSessionRepo examSessionRepo;
    public List<ExamSession> getAllExamSessions() {
        return examSessionRepo.findAll();
    }
    public List<ExamSession> getSubjectExamSessions(Long subjectId) {return examSessionRepo.findBySubjectId(subjectId);}


    public ExamSession startSessionForSubject(Subject subject) {
        ExamSession examSession = new ExamSession(
                subject, new ArrayList<>(),
                false, LocalDate.now()
        );
        return examSessionRepo.save(examSession);
    }

    public ExamSession getExamSessionById(Long id) {
        return examSessionRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Exam session not found with id: " + id)
                );
    }

    public ExamSession saveExamSession(ExamSession examSession) {
        return examSessionRepo.save(examSession);
    }

    public ExamSession assignExam(ExamSession examSession, Exam exam) {
        examSession.addExam(exam);
        exam.setExamSession(examSession);
        return saveExamSession(examSession);
    }
}
