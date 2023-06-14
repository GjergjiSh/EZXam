package com.dbproject.ezexam.dtos;

import com.dbproject.ezexam.entities.ExamSession;
import com.dbproject.ezexam.entities.Topic;

import java.util.List;
import java.util.Optional;

public record SubjectDTO(Long id, String name, Optional<ExamSession> unfinishedSession, List<Topic> topics) {
}
