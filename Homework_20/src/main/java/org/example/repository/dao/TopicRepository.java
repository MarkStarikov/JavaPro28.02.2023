package org.example.repository.dao;

import org.example.model.Question;
import org.example.model.Topic;

import java.util.List;

public interface TopicRepository {
        Topic save(Topic topic);

        Topic getSelected(int id);

        boolean removeSelected(int id);

        int updateSelected(Topic topic);

        List<Topic> getAll();

        Topic getSelectedByName(String name);

}
