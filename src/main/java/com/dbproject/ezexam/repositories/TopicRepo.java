package com.dbproject.ezexam.repositories;

import com.dbproject.ezexam.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepo extends JpaRepository<Topic, Long> {
    List<Topic> findBySubjectId(Long subjectId);
}
