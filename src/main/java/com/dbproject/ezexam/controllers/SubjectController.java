package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.entities.ExamSession;
import com.dbproject.ezexam.entities.Subject;
import com.dbproject.ezexam.entities.Topic;
import com.dbproject.ezexam.services.ExamSessionService;
import com.dbproject.ezexam.services.SubjectService;
import com.dbproject.ezexam.services.TopicService;
import com.dbproject.ezexam.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    private final TopicService topicService;
    private final ExamSessionService examSessionService;

    @GetMapping
    public ResponseEntity<Object> getSubjects() {
        return ResponseUtils.returnSuccess(
                subjectService.getAllSubjects()
        );
    }

    @GetMapping("/{name}")
    public ResponseEntity<Object> getSubjectByName(@PathVariable String name) {
        try {
            return ResponseUtils.returnSuccess(subjectService.getSubjectByName(name));
        } catch (NoSuchElementException e) {
            return ResponseUtils.returnNotFound(e.getMessage());
        }
    }

    @GetMapping("/professor/{id}")
    public ResponseEntity<Object> getProfessorSubjects(@PathVariable Long id) {
        return ResponseUtils.returnSuccess(
                subjectService.getProfessorSubjects(id)
        );
    }

    @GetMapping("/professor/{id}/{subjectId}")
    public ResponseEntity<Object> getProfessorSubject(@PathVariable Long id,
                                                      @PathVariable Long subjectId) {
        try {
            return ResponseUtils.returnSuccess(
                    subjectService.getProfessorSubject(id, subjectId)
            );
        } catch (NoSuchElementException e) {
            return ResponseUtils.returnNotFound(e.getMessage());
        }
    }

    @PutMapping("{id}/topics/")
    public ResponseEntity<Object> addTopicToSubject(@PathVariable Long id,
                                                    @RequestParam String topicName) {
        try {
            Subject subject = subjectService.getSubjectById(id);
            Topic topic = new Topic();
            topic.setQuestions(new ArrayList<>());
            topic.setName(topicName);
            subjectService.addTopicToSubject(subject, topic);
            // topicService.saveTopic(topic); makes topic to be added twice
            return ResponseUtils.returnSuccess(subject);
        } catch (NoSuchElementException e) {
            return ResponseUtils.returnNotFound(e.getMessage());
        }
    }

    @DeleteMapping("{id}/topics")
    // TODO: Ideally done transactionally. All questions removed
    public ResponseEntity<Object> removeTopicFromSubject(@PathVariable Long id,
                                                         @RequestParam Long topicId) {
        try {
            Subject subject = subjectService.getSubjectById(id);
            Topic topic = topicService.getTopicById(topicId);
            subjectService.deleteTopicFromSubject(subject, topic);
            topicService.deleteTopic(topic);
            return ResponseUtils.returnSuccess(subject);
        } catch (NoSuchElementException e) {
            return ResponseUtils.returnNotFound(e.getMessage());
        }
    }

    @PutMapping("{id}/sessions")
    public ResponseEntity<Object> startSessionForSubject(@PathVariable Long id) {
        try {
            Subject subject = subjectService.getSubjectById(id);
            ExamSession examSession = examSessionService.startSessionForSubject(subject);
            return ResponseUtils.returnSuccess(examSession);
        } catch (NoSuchElementException e) {
            return ResponseUtils.returnNotFound(e.getMessage());
        }
    }
}


