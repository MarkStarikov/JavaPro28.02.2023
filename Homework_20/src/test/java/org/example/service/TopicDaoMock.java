package org.example.service;

import org.example.model.Topic;
import org.example.repository.dao.TopicRepository;

import java.util.ArrayList;
import java.util.List;

public class TopicDaoMock implements TopicRepository {
    public List<Topic> topics = new ArrayList<>(){
        {
            add(Topic.builder().id(1).name("OOP").build());
            add(Topic.builder().id(2).name("SQL").build());
            add(Topic.builder().id(3).name("Threads").build());
            add(Topic.builder().id(4).name("Machine Arithmetic").build());
            add(Topic.builder().id(5).name("Spring").build());


        }
    };
    @Override
    public Topic save(Topic topic) {
        topics.add(topic);
        return topic;
    }

    @Override
    public Topic getSelected(int id) {
        for (Topic topic : topics) {
            if (topic.getId() == id)
                return topic;
        }
        return null;
    }

    @Override
    public boolean removeSelected(int id) {
        return false;
    }

    @Override
    public int updateSelected(Topic topic) {
        return 0;
    }

    @Override
    public List<Topic> getAll() {
        return null;
    }

    @Override
    public Topic getSelectedByName(String name) {
        return null;
    }
}
