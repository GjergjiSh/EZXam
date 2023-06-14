package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.config.Role;
import com.dbproject.ezexam.dtos.AddProfessor;
import com.dbproject.ezexam.dtos.AddUser;
import com.dbproject.ezexam.entities.Professor;
import com.dbproject.ezexam.entities.Subject;
import com.dbproject.ezexam.entities.User;
import com.dbproject.ezexam.dtos.ExamSessionReportDTO;
import com.dbproject.ezexam.dtos.SubjectDTO;
import com.dbproject.ezexam.services.ProfessorService;
import com.dbproject.ezexam.services.SubjectService;
import com.dbproject.ezexam.utils.ResponseUtils;
import com.dbproject.ezexam.services.UserDetailsServiceImpl;
import com.dbproject.ezexam.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/professors")
public class ProfessorController {
    @Autowired
    private final ProfessorService professorService;
    @Autowired
    private final UserService userService;
    @Autowired
    private final UserDetailsServiceImpl userDetailsService;
    @Autowired
    SubjectService subjectService;

    @GetMapping("/")
    public ResponseEntity<Object> getProfessors() {
        return ResponseUtils.returnSuccess(
                professorService.getAllProfessors()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProfessorById(@PathVariable Long id) {
        return ResponseUtils.returnSuccess(
                professorService.getProfessorById(id)
        );
    }
    @PostMapping("/addProfessor")
    public ResponseEntity<HttpStatus> addProfessor(@RequestBody AddProfessor addProfessorDTO) {
        if(!userService.Register(
                new AddUser(addProfessorDTO.getUsername(), addProfessorDTO.getPassword(), Role.PROFESSOR)
        ))
            return ResponseEntity.badRequest().build();

        UserDetails addedUser = userDetailsService.loadUserByUsername(addProfessorDTO.getUsername());
        Professor professor = new Professor(addProfessorDTO.getName(), addProfessorDTO.getLastName(), (User) addedUser);
        professorService.saveProfessor(professor);
        return ResponseEntity
                .ok().build();
    }

    @GetMapping("/{professorId}/subjects")
    public ResponseEntity<List<SubjectDTO>> getAllSubjects(@PathVariable long professorId) {
        return professorService.getProfessorSubjects(professorId);
    }

    @GetMapping("/{professorId}/sessions/report")
    public ResponseEntity<List<ExamSessionReportDTO>> getProfessorExamSessionsReport(@PathVariable long professorId) {
        return professorService.getProfessorExamSessionsReport(professorId);
    }

    @PutMapping("/{professorId}/subjects")
    public ResponseEntity<Object> assignSubjectToProfessor(@PathVariable Long professorId, @RequestParam String subjectName) {
        try {
            Professor professor = professorService.getProfessorById(professorId).orElseThrow(
                    () -> new NoSuchElementException("Professor with id " + professorId + " not found")
            );
            Subject subject = new Subject();
            subject.setName(subjectName);
            subject.setExamSessions(new ArrayList<>());
            subject.setTopics(new ArrayList<>());
            professorService.assignSubjectToProfessor(professor, subject);
            subjectService.saveSubject(subject);
            return ResponseUtils.returnSuccess(professor);
        } catch (NoSuchElementException e) {
            return ResponseUtils.returnNotFound(e.getMessage());
        }
    }
}
