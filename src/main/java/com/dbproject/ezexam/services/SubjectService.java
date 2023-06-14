package com.dbproject.ezexam.services;

import com.dbproject.ezexam.entities.ExamSession;
import com.dbproject.ezexam.entities.Subject;
import com.dbproject.ezexam.entities.Topic;
import com.dbproject.ezexam.repositories.SubjectRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepo subjectRepo;

    public List<Subject> getAllSubjects() {
       return subjectRepo.findAll();
    }

    public Subject getSubjectByName(String name) {
        return subjectRepo.findByName(name)
                .orElseThrow(() -> new NoSuchElementException(
                        "Subject not found with name: " + name)
                );
    }

    public List<Subject> getProfessorSubjects(Long id) {
        return subjectRepo.findByProfessorId(id);
    }

    public Subject getProfessorSubject(Long professorId, Long subjectId) {
        return subjectRepo.findByProfessorIdAndId(professorId, subjectId)
                .orElseThrow(() -> new NoSuchElementException(
                        "Subject not found with id: " + subjectId +
                                " and professorId: " + professorId)
                );
    }

    public Subject getSubjectById(Long subjectId) {
        return subjectRepo.findById(subjectId)
                .orElseThrow(() -> new NoSuchElementException(
                        "Subject not found with id: " + subjectId)
                );
    }

    public Subject addTopicToSubject(Subject subject, Topic topic) {
        topic.setSubject(subject);
        subject.addTopic(topic);
        return subjectRepo.save(subject);
    }

    public Subject deleteTopicFromSubject(Subject subject, Topic topic) {
        topic.setSubject(null);
        subject.removeTopic(topic);
        return subjectRepo.save(subject);
    }

    public Subject saveSubject(Subject subject) {
        return subjectRepo.save(subject);
    }
}
