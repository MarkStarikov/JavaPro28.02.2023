package org.example.repository;

import org.example.ConnectionSingleton;
import org.example.model.Topic;
import org.example.repository.dao.TopicRepository;

import java.sql.*;

public class TopicRepositoryImpl implements TopicRepository{

    private final static String CREATE =
            """
            INSERT INTO topic(
            id, name)
            VALUES( ?, ?)        
            """;
    private final static String GET =
            """
            SELECT * FROM topic
            WHERE id = ?
            """;
    private final static String REMOVE =
            """
            DELETE FROM topic
            WHERE id = ?
            """;
    private final static String UPDATE =
            """
            UPDATE topic
            SET text = ?
            WHERE id = ?
            """;
    private final Connection connection = ConnectionSingleton.getConnection();

    @Override
   public boolean save(Topic topic){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, topic.getName());
            preparedStatement.setInt(2, topic.getId());
            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot save data" + topic, e);
        }
    }
    @Override
   public Topic getSelected (int id){
        try {
        PreparedStatement preparedStatement = connection.prepareStatement(GET);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Topic topic = Topic.builder()
                .id(resultSet.getInt(1))
                .name(resultSet.getString(2))
                .build();
        return topic;
    }catch (SQLException e) {
        throw new RuntimeException("Cannot get topic by id" + id, e);
    }
}
    @Override
    public boolean removeSelected (int id){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE);
            preparedStatement.setInt(1, id);
            return preparedStatement.execute();
        }catch (SQLException e) {
            throw new RuntimeException("Cannot remove topic by id" + id, e);
        }
    }

    @Override
    public int updateSelected(Topic topic) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, topic.getName());
            preparedStatement.setInt(2, topic.getId());
            return preparedStatement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Cannot update data" + topic, e);
        }
    }

}
