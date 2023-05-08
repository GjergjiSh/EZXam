package com.dbproject.ezexam.repositories;

import com.dbproject.ezexam.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepo extends JpaRepository<Exam, Long> {
}
