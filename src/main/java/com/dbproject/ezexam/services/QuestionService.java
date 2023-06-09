package com.dbproject.ezexam.services;

import com.dbproject.ezexam.entities.Criteria;
import com.dbproject.ezexam.entities.Question;
import com.dbproject.ezexam.repositories.QuestionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepo questionRepo;
    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }
    public Question getQuestionById(Long id) {
        return questionRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                "Question not found with id: " + id)
        );
    }
    public Question saveQuestion(Question question) {
        return questionRepo.save(question);
    }
    public Question addCriteriaToQuestion(Question question, Criteria criteria) {
        criteria.setQuestion(question);
        question.addCriteria(criteria);
        return questionRepo.save(question);
    }

    public Question deleteCriteriaFromQuestion(Question question, Criteria criteria) {
        question.removeCriteria(criteria);
        return questionRepo.save(question);
    }

    public void deleteQuestion(Question question) {questionRepo.delete(question);}
}
