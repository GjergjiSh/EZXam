package com.dbproject.ezexam.services;

import com.dbproject.ezexam.entities.Subject;
import com.dbproject.ezexam.repositories.SubjectRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepo subjectRepo;

    public List<Subject> getAllSubjects() {
       return subjectRepo.findAll();
    }

    public Optional<Subject> getSubjectByName(String name) {
        return subjectRepo.findByName(name);
    }

}
