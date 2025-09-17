package com.shivam.qoura.utils;

import com.shivam.qoura.dto.Response.AnswerResponse;
import com.shivam.qoura.dto.Response.QuestionResponse;
import com.shivam.qoura.dto.Response.UserResponse;
import com.shivam.qoura.models.Answer;
import com.shivam.qoura.models.Question;
import com.shivam.qoura.models.User;
import org.springframework.stereotype.Component;

@Component
public class Response {

    public static UserResponse userResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .build();
    }

    //not able to fetch topics
    public static QuestionResponse questionResponse(Question question){
        //convert List of topics to List of topic Names
        //List<String> names = question.getTopics().stream().map(Topic::getName).toList();
        return QuestionResponse.builder()
                .id(question.getId())
                .title(question.getTitle())
                .body(question.getBody())
                .userId(question.getUser().getId())
                .build();
    }

    public static AnswerResponse answerResponse(Answer answer){
        return AnswerResponse.builder()
                .answerId(answer.getId())
                .questionId(answer.getQuestion().getId())
                .userId(answer.getUser().getId())
                .text(answer.getText())
                .build();
    }
}
