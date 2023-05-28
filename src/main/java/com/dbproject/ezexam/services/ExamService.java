package com.dbproject.ezexam.services;

import com.dbproject.ezexam.entities.Exam;
import com.dbproject.ezexam.repositories.ExamRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepo examRepo;
    public List<Exam> getAllExams() {
        return examRepo.findAll();
    }
    public Optional<Exam> getExamById(Long id) {
        return examRepo.findById(id);
    }
    public Exam saveExam(Exam exam) {
        return examRepo.save(exam);
    }
}
