package org.example.repository.dao;

import org.example.model.Question;

public interface QuestionRepository {

    boolean save(Question question);

    Question getSelected(int id);

    boolean removeSelected(int id);

    int updateSelected(Question question);

}
