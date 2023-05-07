package com.dbproject.ezexam.repositories;

import com.dbproject.ezexam.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    // Add any custom query methods here if needed
}
