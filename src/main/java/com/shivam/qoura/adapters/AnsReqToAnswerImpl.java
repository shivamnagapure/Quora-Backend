package com.shivam.qoura.adapters;

import com.shivam.qoura.dto.Request.AnswerRequest;
import com.shivam.qoura.models.Answer;
import com.shivam.qoura.models.Question;
import com.shivam.qoura.models.User;
import com.shivam.qoura.service.QuestionService;
import com.shivam.qoura.service.UserService;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

@Component
public class AnsReqToAnswerImpl implements AnsReqToAnswer{

    UserService userService ;
    QuestionService questionService ;

    public AnsReqToAnswerImpl(UserService userService , QuestionService questionService){
        this.userService = userService ;
        this.questionService = questionService ;
    }

    @Override
    public Answer convertToAnswer(AnswerRequest answerRequest) {
        System.out.println(answerRequest.getQuestionId());
        User user = userService.findUserById(answerRequest.getUserId());
        Question question = questionService.findQuestionById(answerRequest.getQuestionId());
        return Answer.builder()
                .user(user)
                .question(question)
                .text(answerRequest.getText())
                .build();
    }
}
