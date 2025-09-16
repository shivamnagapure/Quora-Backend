package com.shivam.qoura.adapters;

import com.shivam.qoura.dto.Request.QuestionRequest;
import com.shivam.qoura.models.Question;
import com.shivam.qoura.models.Topic;
import com.shivam.qoura.models.User;
import com.shivam.qoura.repositories.QuestionRepository;
import com.shivam.qoura.service.QuestionService;
import com.shivam.qoura.service.TopicService;
import com.shivam.qoura.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
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
        System.out.println(findUser.getUserName());
        System.out.println(questionRequest.getTopics());
        List<Topic> topicss = topicService.getTopicsByName(questionRequest.getTopics());
        System.out.println(topicss);
        System.out.println("Topics get by name");
        return Question.builder()
                .user(findUser)
                .title(questionRequest.getTitle())
                .body(questionRequest.getBody())
                .topics(topicss)
                .build();
    }
}
