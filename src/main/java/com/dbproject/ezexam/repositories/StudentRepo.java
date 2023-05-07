package com.dbproject.ezexam.repositories;

import com.dbproject.ezexam.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Optional<Student> findByNameAndLastname(String name, String lastname);
}
