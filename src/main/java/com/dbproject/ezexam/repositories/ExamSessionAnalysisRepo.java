package com.dbproject.ezexam.repositories;

import com.dbproject.ezexam.entities.ExamSessionAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamSessionAnalysisRepo extends JpaRepository<ExamSessionAnalysis, Long> {

    public ExamSessionAnalysis getExamSessionAnalysisByExamSessionId(Long examSessionId);
}
