package com.dbproject.ezexam.services;

import com.dbproject.ezexam.entities.Exam;
import com.dbproject.ezexam.entities.ExamSession;
import com.dbproject.ezexam.repositories.ExamSessionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamSessionService {
    private final ExamSessionRepo examSessionRepo;

    public List<ExamSession> getAllExamSessions() {
        return examSessionRepo.findAll();
    }

    public List<ExamSession> getSubjectExamSessions(Long subjectId) {return examSessionRepo.findBySubjectId(subjectId);}
}
