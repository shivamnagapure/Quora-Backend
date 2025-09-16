package com.shivam.qoura.utils;

import com.shivam.qoura.dto.Response.QuestionResponse;
import com.shivam.qoura.dto.Response.UserResponse;
import com.shivam.qoura.models.Question;
import com.shivam.qoura.models.Topic;
import com.shivam.qoura.models.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
//                .userId(question)
                .build();
    }
}
