package com.dbproject.ezexam.services;

import com.dbproject.ezexam.dtos.ExamDTO;
import com.dbproject.ezexam.dtos.ExamSessionReportDTO;
import com.dbproject.ezexam.dtos.SubjectDTO;
import com.dbproject.ezexam.entities.*;
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
    private final ExamSessionAnalysisService examSessionAnalysisService;

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
                .map(subject -> new SubjectDTO(subject.getId(), subject.getName(), subject.getExamSessions().stream().filter(examSession -> !examSession.getFinished()).findFirst(), subject.getTopics()))
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
        int fails = 0;
        int passes = 0;
        double highestGrade = 6.0;
        double averageGrade = 6.0;
        ExamSessionAnalysis examSessionAnalysis = examSessionAnalysisService.getExamSessionAnalysisBySessionId(examSession.getId());
        if (examSessionAnalysis != null) {
            highestGrade = examSessionAnalysis.getHighestGrade();
            averageGrade = examSessionAnalysis.getAverageGrade();
            passes = examSessionAnalysis.getPass();
            fails = examSessionAnalysis.getFail();
        }
        List<ExamDTO> examDTOs = new ArrayList<>();
        for (Exam exam : examSession.getExams()) {
            examDTOs.add(new ExamDTO(exam.getStudent().getMatnr(), exam.getGrade()));
        }

        return new ExamSessionReportDTO(subject.getName(), examSession.getDate(), highestGrade, averageGrade, fails, passes, examDTOs);
    }
}