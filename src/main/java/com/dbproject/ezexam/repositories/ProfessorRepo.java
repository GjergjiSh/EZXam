package com.dbproject.ezexam.repositories;

import com.dbproject.ezexam.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepo extends JpaRepository<Professor, Long> {
}