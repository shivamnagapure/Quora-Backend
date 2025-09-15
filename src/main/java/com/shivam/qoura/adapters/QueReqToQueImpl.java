package com.shivam.qoura.adapters;

import com.shivam.qoura.dto.Request.QuestionRequest;
import com.shivam.qoura.models.Question;
import com.shivam.qoura.models.Topic;
import com.shivam.qoura.models.User;
import com.shivam.qoura.repositories.QuestionRepository;
import com.shivam.qoura.service.QuestionService;
import com.shivam.qoura.service.TopicService;
import com.shivam.qoura.service.UserService;

import java.util.List;
import java.util.Optional;

public class QueReqToQueImpl implements QueReqToQue{

    UserService userService ;
    TopicService topicService ;


    public QueReqToQueImpl(UserService userService  , TopicService topicService){
        this.userService = userService ;
        this.topicService = topicService ;
    }

    @Override
    public Question convertToQuestion(QuestionRequest questionRequest) {
        User findUser = userService.findUserById(questionRequest.getUserId());
        List<Topic> topics = topicService.getTopicsByName(questionRequest.getTopics());
        return Question.builder()
                .user(findUser)
                .title(questionRequest.getTitle())
                .body(questionRequest.getBody())
                .topics(topics)
                .build();
    }
}
