package com.dbproject.ezexam.services;

import com.dbproject.ezexam.entities.ExamSessionAnalysis;
import com.dbproject.ezexam.repositories.ExamSessionAnalysisRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamSessionAnalysisService {

    private final ExamSessionAnalysisRepo examSessionAnalysisRepo;

    public ExamSessionAnalysis getExamSessionAnalysisBySessionId(Long examSessionId) {
        return examSessionAnalysisRepo.getExamSessionAnalysisByExamSessionId(examSessionId);
    }
}
