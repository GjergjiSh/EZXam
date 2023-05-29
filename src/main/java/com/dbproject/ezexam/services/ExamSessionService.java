package com.dbproject.ezexam.services;

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

    public void saveExamSession(ExamSession examSession) {
        examSessionRepo.save(examSession);
    }
}
