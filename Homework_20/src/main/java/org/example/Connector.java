package org.example;

import org.example.model.Question;
import org.example.model.Topic;
import org.example.service.QuestionService;
import org.example.service.TopicService;

import java.util.List;
import java.util.Scanner;

public class Connector {
    private final QuestionService questionService;
    private final TopicService topicService;
    private final Scanner scanner;

    public Connector(QuestionService questionService, TopicService topicService, Scanner scanner) {
        this.questionService = questionService;
        this.topicService = topicService;
        this.scanner = scanner;
    }

    public void start() {
        Commands[] statements = Commands.values();
        System.out.println("Please, select identifier of command which you would like to run");
        for (Commands command : statements) {
            System.out.println(command.command);
        }
        String statementIdentifier;
        statementIdentifier = scanner.nextLine();
        switch (statementIdentifier) {
            case "G1" -> getRandomQuestionByTopic();
            case "G2" -> getRandomQuestion();
            case "G3" -> getTopic();
            case "R1" -> deleteQuestion();
            case "A1" -> saveQuestion();
            case "A2" -> saveTopic();
            default -> throw new WrongInsertStatement("You insert nonexistent statement");
        }
        System.out.println("Do you complete all necessary action");
        String answer = scanner.nextLine().toLowerCase();
        if (answer.equals("no")) {
            start();
        } else System.out.println("Wishing you all the best");

    }
    private void getRandomQuestion(){
        System.out.println("Question: "+ questionService.getRandom().getText()+ "\n");
    }
    private Topic comparator(){
        System.out.println("Select topic");
        List<Topic> topics = getTopic();
        Topic topicEntry = null;
        String topic = scanner.nextLine();
        for (Topic concretTopic : topics) {
            if (topic.equals(concretTopic.getName())) {
                topicEntry = concretTopic;
            }
        }
        if (topicEntry != null){
            return topicEntry;
        } else throw new WrongInsertStatement("Topic with such name is absent in database");
    }
    private void getRandomQuestionByTopic(){
        String topicName = comparator().getName();
            System.out.println("Question "+ questionService.getRandomByTopic(topicName).getText() + "\n");
    }
    private void saveQuestion(){
        int topicId = comparator().getId();
        System.out.println("Please, insert question, what you need to add: ");
        String question = scanner.nextLine();
        questionService.save(Question.builder().text(question).topicId(topicId).build());
        System.out.println("Question add successfully" + "\n");
    }
    private void  deleteQuestion() {
        System.out.println("Please, insert question, what you need to remove: ");
        int questionId;
        if (scanner.hasNextInt()) {
            questionId = scanner.nextInt();
            questionService.deleteQuestion(questionId);
            System.out.println("Question remove successfully" + "\n");
        }else {
            System.out.println("Wrong insert. Please try again");
        }
    }
    private void saveTopic(){
        System.out.println("Please, insert topic, what you need to add: ");
        String topic = scanner.nextLine();
        topicService.save(Topic.builder().name(topic).build());
        System.out.println("Topic add successfully" + "\n");
    }
    private List<Topic>  getTopic() {
        List<Topic> topics = topicService.getAllTopics();
        for (Topic item : topics){
            System.out.println(item.getName());
        }
        return topics;
    }
}
