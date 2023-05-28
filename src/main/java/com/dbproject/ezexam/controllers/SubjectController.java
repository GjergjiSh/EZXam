package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.entities.Subject;
import com.dbproject.ezexam.entities.Topic;
import com.dbproject.ezexam.services.SubjectService;
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
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    private final TopicService topicService;

    @GetMapping
    public ResponseEntity<List<Subject>> getSubjects() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(subjectService.getAllSubjects());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Object> getSubjectByName(@PathVariable String name) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(subjectService.getSubjectByName(name));
        } catch (NoSuchElementException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/professor/{id}")
    public ResponseEntity<Object> getProfessorSubjects(@PathVariable Long id) {
        List<Subject> subjects = subjectService.getProfessorSubjects(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(subjects);
    }

    @GetMapping("/professor/{id}/{subjectId}")
    public ResponseEntity<Object> getProfessorSubject(@PathVariable Long id, @PathVariable Long subjectId) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(subjectService.getProfessorSubject(id, subjectId));
        } catch (NoSuchElementException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(e.getMessage());
        }
    }

    @PutMapping("{id}/topics/")
    public ResponseEntity<Subject> addTopicToSubject(@PathVariable Long id, @RequestParam String topicName) {
        try {
            Subject subject = subjectService.getSubjectById(id);
            Topic topic = new Topic();
            topic.setQuestions(new ArrayList<>());
            topic.setName(topicName);
            subjectService.addTopicToSubject(subject, topic);
            topicService.saveTopic(topic);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(subject);
        } catch (NoSuchElementException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .build();
        }
    }
}


