package com.dbproject.ezexam.services;

import com.dbproject.ezexam.entities.Student;
import com.dbproject.ezexam.repositories.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> getStudentByMatnr(String matnr) {
        return studentRepository.findByMatnr(matnr);
    }

    public List<Student> getStudentsByFullName(String name, String lastname) {
        return studentRepository.findAllByNameAndLastname(name,lastname);
    }
}