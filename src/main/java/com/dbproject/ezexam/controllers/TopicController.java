package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.entities.Question;
import com.dbproject.ezexam.entities.Topic;
import com.dbproject.ezexam.services.QuestionService;
import com.dbproject.ezexam.services.TopicService;
import com.dbproject.ezexam.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/topics")
public class TopicController {
    private final TopicService topicService;
    private final QuestionService questionService;

    @GetMapping
    public ResponseEntity<Object> getTopics() {
        return ResponseUtils.returnSuccess(topicService.getAllTopics());
    }

    @PutMapping("/{topicId}/questions")
    public ResponseEntity<Object> addQuestionToTopic(@PathVariable Long topicId, @RequestParam String questionDescription, @RequestParam String questionText) {
        try {
            Topic topic = topicService.getTopicById(topicId);
            Question question = new Question();
            question.setText(questionDescription);
            question.setDescription(questionDescription);
            question.setCriterias(new ArrayList<>());
            topicService.addQuestionToTopic(topic, question);
            return ResponseUtils.returnSuccess(topic);
        } catch (NoSuchElementException e) {
            return ResponseUtils.returnNotFound(e.getMessage());
        }
    }

    @DeleteMapping("/{topicId}/questions/")
    public ResponseEntity<Object> deleteQuestionFromTopic(@PathVariable Long topicId, @RequestParam Long questionId) {
        try {
            Topic topic = topicService.getTopicById(topicId);
            Question question = questionService.getQuestionById(questionId);
            topicService.removeQuestionFromTopic(topic, question);
            questionService.deleteQuestion(question);
            return ResponseUtils.returnSuccess(topic);
        } catch (NoSuchElementException e) {
            return ResponseUtils.returnNotFound(e.getMessage());
        }
    }
}
