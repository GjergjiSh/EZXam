package com.dbproject.ezexam.services;

import com.dbproject.ezexam.entities.Exam;
import com.dbproject.ezexam.entities.Student;
import com.dbproject.ezexam.repositories.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepository;
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                "Student not found with id: " + id)
        );
    }
    public Student getStudentByMatnr(String matnr) {
        return studentRepository.findByMatnr(matnr)
                .orElseThrow(() -> new NoSuchElementException(
                "Student not found with matnr: " + matnr)
        );
    }
    public List<Student> getStudentsByFullName(String name, String lastname) {
        return studentRepository.findAllByNameAndLastname(name,lastname);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student assignExam(Student student, Exam exam) {
        student.addExam(exam);
        exam.setStudent(student);
        return saveStudent(student);
    }
}