package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.entities.Question;
import com.dbproject.ezexam.entities.Topic;
import com.dbproject.ezexam.services.QuestionService;
import com.dbproject.ezexam.services.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/topics")
public class TopicController {
    private final TopicService topicService;
    private final QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<Topic>> getTopics() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(topicService.getAllTopics());
    }

    @PutMapping("/{topicId}/questions")
    public ResponseEntity<Object> addQuestionToTopic(@PathVariable Long topicId, @RequestParam String questionDescription) {
        try {
            Topic topic = topicService.getTopicById(topicId);
            Question question = new Question();
            question.setDescription(questionDescription);
            question.setCriterias(new ArrayList<>());
            topicService.addQuestionToTopic(topic, question);
            questionService.saveQuestion(question);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(topic);
        } catch (NoSuchElementException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(e.getMessage());
        }
    }
}
