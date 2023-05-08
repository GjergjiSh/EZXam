package com.dbproject.ezexam.services;

import com.dbproject.ezexam.entities.Question;
import com.dbproject.ezexam.repositories.QuestionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepo questionRepo;

    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }
}
