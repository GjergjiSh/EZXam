package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.dtos.ExamSessionReportDTO;
import com.dbproject.ezexam.dtos.SubjectDTO;
import com.dbproject.ezexam.services.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/professors")
public class ProfessorController {
    private final ProfessorService professorService;

    @GetMapping("/")
    public ResponseEntity<Object> getProfessors() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(professorService.getAllProfessors());
    }

    @GetMapping("/{professorId}/subjects")
    public ResponseEntity<List<SubjectDTO>> getAllSubjects(@PathVariable long professorId) {
        return professorService.getProfessorSubjects(professorId);
    }

    @GetMapping("/{professorId}/sessions/report")
    public ResponseEntity<List<ExamSessionReportDTO>> getProfessorExamSessionsReport(@PathVariable long professorId) {
        return professorService.getProfessorExamSessionsReport(professorId);
    }
}
