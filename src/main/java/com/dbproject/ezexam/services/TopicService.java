package com.dbproject.ezexam.services;

import com.dbproject.ezexam.entities.Topic;
import com.dbproject.ezexam.repositories.TopicRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepo topicRepo;

    public List<Topic> getAllTopics() {
        return topicRepo.findAll();
    }
}
