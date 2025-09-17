package com.shivam.qoura.service;

import com.shivam.qoura.models.Answer;
import com.shivam.qoura.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    AnswerRepository answerRepository ;

    public AnswerService(AnswerRepository answerRepository){
        this.answerRepository = answerRepository ;
    }

    public Answer saveAnswer(Answer answer){
        return answerRepository.save(answer);

    }
}
