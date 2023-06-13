package org.example.service;

import org.example.model.Question;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class QuestionServiceTest {
    private final QuestionDaoMock questionDaoMock = new QuestionDaoMock();

    private QuestionService questionService;
    @Before
    public void initiate() {
        questionService = new QuestionService(questionDaoMock);
    }
    @Test
    public void getRandomTest() {
        System.out.println(questionService.getRandom());


    }
    @Test
    public void saveTest() {
        Question question = Question.builder().id(5).text(" What is Hibernate?").topicId(5).build();
        questionService.save(question);

        Assert.assertTrue(questionDaoMock.questions.contains(question));
    }
    @Test
    public void deleteQuestionTest() {
        questionService.deleteQuestion(1);

        Assert.assertFalse(questionDaoMock.questions.contains(1));
    }

    @Test
    public void getRandomByTopicTest() {
        String name = "SQL";
        System.out.println(questionService.getRandomByTopic(name));

    }
}
