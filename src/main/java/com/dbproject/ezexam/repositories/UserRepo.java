package com.dbproject.ezexam.repositories;

import com.dbproject.ezexam.entities.Student;
import com.dbproject.ezexam.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Student, Long> {
    Optional<User> findByUsername(String username);
}
