package org.example.repository.dao;

import org.example.model.Topic;

public interface TopicRepository {
        boolean save(Topic topic);

        Topic getSelected(int id);

        boolean removeSelected(int id);

        int updateSelected(Topic topic);


}
