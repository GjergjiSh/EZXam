package com.dbproject.ezexam.services;

import com.dbproject.ezexam.dtos.ExamDTO;
import com.dbproject.ezexam.dtos.ExamSessionReportDTO;
import com.dbproject.ezexam.dtos.SubjectDTO;
import com.dbproject.ezexam.entities.Exam;
import com.dbproject.ezexam.entities.ExamSession;
import com.dbproject.ezexam.entities.Professor;
import com.dbproject.ezexam.entities.Subject;
import com.dbproject.ezexam.repositories.ProfessorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepo professorRepository;
    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }
    public Optional<Professor> getProfessorById(Long id) {
        return professorRepository.findById(id);
    }
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }
    public void deleteProfessor(Long id) {
        professorRepository.deleteById(id);
    }

    public ResponseEntity<List<SubjectDTO>> getProfessorSubjects(long professorId) {
        Optional<Professor> professor = getProfessorById(professorId);
        return professor.map(value -> ResponseEntity.ok(value.getSubjects()
                .stream()
                .map(subject -> new SubjectDTO(subject.getId(), subject.getName(), subject.getTopics()))
                .collect(Collectors.toList()))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<ExamSessionReportDTO>> getProfessorExamSessionsReport(long professorId) {
        Optional<Professor> professor = getProfessorById(professorId);
        return professor.map(value -> ResponseEntity.ok(value.getSubjects().stream().map(subject ->
                subject.getExamSessions().stream().map(examSession ->
                        getExamSessionReportDTO(subject, examSession)
                ).toList()
        ).flatMap(Collection::stream).toList())).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private ExamSessionReportDTO getExamSessionReportDTO(Subject subject, ExamSession examSession) {
        List<Exam> exams = examSession.getExams();
        List<ExamDTO> examDTOs = new ArrayList<>();
        List<Double> grades = new ArrayList<>();
        double highestGrade = 6.0;
        int fails = 0;
        int passes = 0;
        for (Exam exam : exams) {
            double grade = exam.getGrade();
            grades.add(grade);
            if (grade >= 4.0) {
                fails++;
            } else {
                passes++;
                highestGrade = Math.min(highestGrade, grade);
            }
            examDTOs.add(new ExamDTO(exam.getStudent().getMatnr(), exam.getGrade()));
        }

        double averageGrade = grades.stream().reduce(0.0, Double::sum) / grades.size();
        return new ExamSessionReportDTO(subject.getName(), examSession.getDate(), highestGrade, averageGrade, fails, passes, examDTOs);
    }
}