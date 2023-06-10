package org.example.repository;

import org.example.ConnectionSingleton;
import org.example.model.Question;
import org.example.repository.dao.QuestionRepository;

import java.sql.*;

public class QuestionRepositoryImpl implements QuestionRepository {
    private final static String CREATE =
            """
            INSERT INTO postgres.question(test, topic_id)
            VALUES (?, ?)        
            """;
    private final static String GET =
            """
            SELECT * FROM postgres.question
            WHERE id = ?
            """;
    private final static String REMOVE =
            """
            DELETE FROM postgres.question
            WHERE id = ?
            """;
    private final static String UPDATE =
            """
            UPDATE postgres.question
            SET text = ?, topic_id = ?
            WHERE id = ?
            """;
    private final Connection connection = ConnectionSingleton.getConnection();

    @Override
    public boolean save(Question question){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, question.getText());
            preparedStatement.setInt(2, question.getTopicId());
            return preparedStatement.execute();
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
}
