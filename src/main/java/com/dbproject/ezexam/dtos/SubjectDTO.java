package com.dbproject.ezexam.dtos;

import com.dbproject.ezexam.entities.Topic;

import java.util.List;

public record SubjectDTO(Long id, String name, List<Topic> topics) {
}
