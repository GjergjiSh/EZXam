package com.dbproject.ezexam.services;

import com.dbproject.ezexam.entities.Question;
import com.dbproject.ezexam.repositories.QuestionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepo questionRepo;

    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }

    public Optional<Question> getQuestionById(Long id) {
        return questionRepo.findById(id);
    }

}
