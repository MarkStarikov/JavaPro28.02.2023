package org.example.repository;

import org.example.ConnectionSingleton;
import org.example.model.Question;
import org.example.model.Topic;
import org.example.repository.dao.QuestionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository {
    private final static String CREATE =
            """
            INSERT INTO question(text, topic_id)
            VALUES (?, ?)        
            """;
    private final static String GET =
            """
            SELECT * FROM question
            WHERE id = ?
            """;
    private final static String REMOVE =
            """
            DELETE FROM question
            WHERE id = ?
            """;
    private final static String UPDATE =
            """
            UPDATE question
            SET text = ?, topic_id = ?
            WHERE id = ?
            """;
    private final static String JOIN =
            """
            SELECT * FROM question
            INNER JOIN topic 
            ON question.topic_id = topic.id
            WHERE name = ?  
            """;
    private final Connection connection = ConnectionSingleton.getConnection();

    @Override
    public Question save(Question question){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE,
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, question.getText());
            preparedStatement.setInt(2, question.getTopicId());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            question.setId(resultSet.getInt(1));

            return question;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot save data" + question, e);
        }

    }
    @Override
    public Question getSelected (int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return Question.builder()
                    .id(resultSet.getInt(1))
                    .text(resultSet.getString(2))
                    .topicId(resultSet.getInt(3))
                    .build();
        }catch (SQLException e) {
            throw new RuntimeException("Cannot get question by id" + id, e);
       }
    }
    @Override
    public boolean removeSelected (int id){
        try{
        PreparedStatement preparedStatement = connection.prepareStatement(REMOVE);
        preparedStatement.setInt(1, id);
        return preparedStatement.execute();
        }catch (SQLException e) {
            throw new RuntimeException("Cannot remove question by id" + id, e);
        }
    }

    @Override
    public int updateSelected(Question question) {
        try{
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, question.getText());
        preparedStatement.setInt(2, question.getTopicId());
        preparedStatement.setInt(3, question.getId());
        return preparedStatement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Cannot update data" + question, e);
        }
    }
    @Override
    public List<Question> getAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM question");
            ArrayList<Question> questions = new ArrayList<>();
            while (resultSet.next()){
                Question build = Question.builder()
                        .text(resultSet.getString(2))
                        .id(resultSet.getInt(1))
                        .topicId(Topic.builder().id(resultSet.getInt(3)).build().getId())
                        .build();
                questions.add(build);
            }
            return questions;
        }catch (SQLException e) {
            throw new RuntimeException("Cannot get all questions", e);
        }
    }

    @Override
    public List<Question> getByTopic(String topicName) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(JOIN);
            preparedStatement.setString(1, topicName);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Question> questionsByTopic = new ArrayList<>();
            while (resultSet.next()){
                Question build = Question.builder()
                        .text(resultSet.getString(2))
                        .id(resultSet.getInt(1))
                        .topicId(Topic.builder().id(resultSet.getInt(3)).build().getId())
                        .build();
                questionsByTopic.add(build);
            }
            return questionsByTopic;
        }catch (SQLException e) {
            throw new RuntimeException("Cannot get questions by name of topic", e);
        }
    }

}
