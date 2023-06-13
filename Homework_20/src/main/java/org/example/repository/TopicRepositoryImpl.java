package org.example.repository;

import org.example.ConnectionSingleton;
import org.example.model.Question;
import org.example.model.Topic;
import org.example.repository.dao.TopicRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            SET name = ?
            WHERE id = ?
            """;
    private final static String READ =
            """
            SELECT * FROM topic
            WHERE name = ?
            """;
    private final Connection connection = ConnectionSingleton.getConnection();

    @Override
   public Topic save(Topic topic){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, topic.getName());
            preparedStatement.setInt(2, topic.getId());
            preparedStatement.execute();
            return topic;
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

    @Override
    public List<Topic> getAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM topic");
            ArrayList<Topic> topics = new ArrayList<>();
            while (resultSet.next()) {
                Topic build = Topic.builder()
                        .name(resultSet.getString(2))
                        .id(resultSet.getInt(1))
                        .build();
                topics.add(build);
            }
            return topics;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot get topics", e);
        }
    }

    @Override
    public Topic getSelectedByName(String name) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(READ);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Topic topic = Topic.builder()
                    .id(resultSet.getInt(1))
                    .name(resultSet.getString(2))
                    .build();
            return topic;
        }catch (SQLException e) {
            throw new RuntimeException("Cannot get topic by name" + name, e);
        }
    }
}
