package com.dbproject.ezexam.repositories;

import com.dbproject.ezexam.entities.ExamSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamSessionRepo extends JpaRepository<ExamSession, Long> {
    List<ExamSession> findBySubjectId(Long subjectId);
}
