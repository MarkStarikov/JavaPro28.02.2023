package org.example;

import org.example.repository.QuestionRepositoryImpl;
import org.example.repository.TopicRepositoryImpl;
import org.example.service.QuestionService;
import org.example.service.TopicService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuestionRepositoryImpl questionRepositoryPostgre = new QuestionRepositoryImpl();
        QuestionService questionService = new QuestionService(questionRepositoryPostgre);
        TopicRepositoryImpl topicRepositoryPostgre = new TopicRepositoryImpl();
        TopicService topicService = new TopicService(topicRepositoryPostgre);
        Connector medium = new Connector(questionService, topicService, scanner);
        System.out.println("""
                Hello user! Please insert command below.\s
                If you want receive random question by certain topic - insert G1\s
                receive random question by all topics - insert G2\s
                receive topic - insert G3\s
                remove question - insert R1\s
                add question - insert A1\s
                add topic - insert A2\s
                """);
        medium.start();
        scanner.close();
    }
}

