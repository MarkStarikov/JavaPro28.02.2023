package org.example.repository.dao;

import org.example.model.Question;

import java.util.List;

public interface QuestionRepository {

    Question save(Question question);

    Question getSelected(int id);

    boolean removeSelected(int id);

    int updateSelected(Question question);

    List<Question> getAll();

    List<Question> getByTopic(String topicName);

}
