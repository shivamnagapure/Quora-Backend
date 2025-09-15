package com.shivam.qoura.service;

import com.shivam.qoura.models.Question;
import com.shivam.qoura.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {

    QuestionRepository questionRepository ;

    public  QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository ;
    }

    public Question findQuestionById(Long Id){
        Optional<Question> question = questionRepository.findById(Id) ;
        return question.get();
    }

    public Question saveQuestion(Question question){
        return questionRepository.save(question);
    }

}
