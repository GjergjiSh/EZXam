package com.dbproject.ezexam.services;

import com.dbproject.ezexam.entities.Professor;
import com.dbproject.ezexam.repositories.ProfessorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}