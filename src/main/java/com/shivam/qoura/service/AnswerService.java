package com.shivam.qoura.service;

import com.shivam.qoura.dto.Request.AnswerRequest;
import com.shivam.qoura.models.Answer;
import com.shivam.qoura.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService {

    AnswerRepository answerRepository ;

    public AnswerService(AnswerRepository answerRepository){
        this.answerRepository = answerRepository ;
    }

    public Answer saveAnswer(Answer answer){
        return answerRepository.save(answer);
    }

    public Answer findAnswerById(Long answerId){
        Optional<Answer> answer =  answerRepository.findById(answerId);
        return answer.orElse(null);
    }

    public Answer replaceAnswer(AnswerRequest answerRequest , Long answerId){
        Optional<Answer> existingAnswer =  answerRepository.findById(answerId);

        existingAnswer.get().setText(answerRequest.getText());

        return answerRepository.save(existingAnswer.get());
    }
}
