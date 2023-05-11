package com.dbproject.ezexam.services;

import com.dbproject.ezexam.entities.Answer;
import com.dbproject.ezexam.entities.Enrollment;
import com.dbproject.ezexam.entities.ExamResult;
import com.dbproject.ezexam.entities.Question;
import com.dbproject.ezexam.repositories.ExamRepo;
import com.dbproject.ezexam.repositories.ExamResultRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExamResultService {
    private final ExamResultRepo examResultRepository;

    public ExamResult createExamResult(Enrollment enrollment) {
        ExamResult examResult = new ExamResult(enrollment);
        System.out.println(examResult);
        return examResultRepository.save(examResult);
    }

    public ExamResult createExamResult(ExamResult examResult) {
        return examResultRepository.save(examResult);
    }

    public void addAnswerToExamResult(ExamResult examResult, Answer answer) {
        examResult.addAnswer(answer);
        examResultRepository.save(examResult);
    }

    public void removeAnswerFromExamResult(ExamResult examResult, Answer answer) {
        examResult.removeAnswer(answer);
        examResultRepository.save(examResult);
    }

    public Optional<ExamResult> getExamResult(Long resultId) {
        return examResultRepository.findById(resultId);
    }

    public List<ExamResult> getAllExamResults() {
        return examResultRepository.findAll();
    }
}
