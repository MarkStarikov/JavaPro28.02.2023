package org.example.service;

import org.example.model.Question;
import org.example.repository.dao.QuestionRepository;

import java.util.List;
import java.util.Random;

public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions (){
        return questionRepository.getAll();
    }
    public Question getRandom() {
        return getQuestion(questionRepository.getAll());
    }

    public Question getRandomByTopic(String topicName) {
        List<Question> allQuestionsOfTopic = this.questionRepository.getByTopic(topicName);
        return getQuestion(allQuestionsOfTopic);
    }
    public Question save (Question question){
        return this.questionRepository.save(question);

    }
    public boolean deleteQuestion(int id){
        return this.questionRepository.removeSelected(id);
    }
    private Question getQuestion (List<Question> questions){
        int random = new Random().nextInt(questions.size());
        return questions.get(random);
    }

}
