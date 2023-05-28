package com.dbproject.ezexam.services;

import com.dbproject.ezexam.entities.Question;
import com.dbproject.ezexam.entities.Subject;
import com.dbproject.ezexam.entities.Topic;
import com.dbproject.ezexam.repositories.TopicRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepo topicRepo;

    public List<Topic> getAllTopics() {
        return topicRepo.findAll();
    }

    public List<Topic> getTopicsBySubjectId(Long subjectId) {
        return topicRepo.findBySubjectId(subjectId);
    }

    public Topic saveTopic(Topic topic) {
        return topicRepo.save(topic);
    }

    public void deleteTopic(Topic topic) {
        topicRepo.delete(topic);
    }

    public Topic getTopicById(Long id) {
        return topicRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                "Topic not found with id: " + id)
        );
    }

    public Topic addQuestionToTopic(Topic topic, Question question) {
        question.setTopic(topic);
        topic.addQuestion(question);
        return topicRepo.save(topic);
    }
}
