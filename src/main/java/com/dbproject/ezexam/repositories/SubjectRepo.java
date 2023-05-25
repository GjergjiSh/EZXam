package com.dbproject.ezexam.repositories;

import com.dbproject.ezexam.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {
    Optional<Subject> findByName(String name);

    List<Subject> findByProfessorId(Long professorId);

    Optional<Subject> findByProfessorIdAndId(Long professorId, Long subjectId);
}
