package org.example.service;

import org.example.model.Topic;
import org.example.repository.dao.TopicRepository;

import java.util.List;
;

public class TopicService {

    private final TopicRepository topicRepository;


    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;

    }

    public List<Topic> getAllTopics() {
        return topicRepository.getAll();
    }

    public Topic getTopic(int id) {
        return topicRepository.getSelected(id);
    }

    public Topic save(Topic topic) {
        return topicRepository.save(topic);

    }
}
