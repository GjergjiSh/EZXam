package com.dbproject.ezexam.services;

import com.dbproject.ezexam.entities.Answer;
import com.dbproject.ezexam.repositories.AnswerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepo answerRepo;

    public Answer saveAnswer(Answer answer) {
        return answerRepo.save(answer);
    }

    public void deleteAnswer(Long answerId) {
        answerRepo.deleteById(answerId);
    }
}