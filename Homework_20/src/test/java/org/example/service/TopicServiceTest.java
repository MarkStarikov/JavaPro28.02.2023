package org.example.service;

import org.example.model.Topic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class TopicServiceTest {
    private final TopicDaoMock topicDaoMock = new TopicDaoMock();
    private TopicService topicService;
    @Before
    public void initiate() {
        topicService = new TopicService(topicDaoMock);
    }
    @Test
    public void getTopicTest(){
        Topic topic = Topic.builder().id(1).name("OOP").build();
        topicDaoMock.topics.add(topic);

        Topic expected = topicService.getTopic(topic.getId());

        Assert.assertEquals(topic, expected);

    }
    @Test
    public void saveTest(){
        Topic topic = Topic.builder().id(5).name("Hibernate").build();
        topicService.save(topic);

        Assert.assertTrue(topicDaoMock.topics.contains(topic));

    }
}
