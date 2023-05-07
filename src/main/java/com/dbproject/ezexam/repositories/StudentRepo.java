package com.dbproject.ezexam.repositories;

import com.dbproject.ezexam.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findAllByNameAndLastname(String name, String lastname);
    Optional<Student> findByMatnr(String matnr);
}
