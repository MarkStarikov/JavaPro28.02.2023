package org.example.service;

import org.example.model.Question;
import org.example.model.Topic;
import org.example.repository.dao.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

public class QuestionDaoMock implements QuestionRepository {
    public List<Question> questions = new ArrayList<>() {
        {
            add(Question.builder().id(1).text("What is loop?").topicId(1).build());
            add(Question.builder().id(2).text("What is method?").topicId(1).build());
            add(Question.builder().id(3).text("What is query?").topicId(2).build());
            add(Question.builder().id(4).text("What is what is process?").topicId(3).build());
            add(Question.builder().id(5).text("What is conjunction?").topicId(4).build());
            add(Question.builder().id(6).text("What is Hibernate?").topicId(5).build());

        }
    };

    @Override
    public Question save(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question getSelected(int id) {
        return null;
    }

    @Override
    public boolean removeSelected(int id) {
        questions.remove(id);
        return false;
    }

    @Override
    public int updateSelected(Question question) {
        return 0;
    }

    @Override
    public List<Question> getAll() {
        return questions;
    }

    @Override
    public List<Question> getByTopic(String topicName) {
        List<Topic> topics = List.of(
                Topic.builder().id(2).name("SQL").build(),
                Topic.builder().id(3).name("Hibernate").build()
                );
        Topic unit = topics.stream()
                .filter(t -> t.getName().equals(topicName))
                .findFirst()
                .get();
         return questions.stream()
                 .filter(q -> q.getTopicId() == unit.getId())
                 .toList();

    }
}
