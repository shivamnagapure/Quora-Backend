package com.shivam.qoura.service;

import com.shivam.qoura.models.Topic;
import com.shivam.qoura.repositories.TopicsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    TopicsRepository topicsRepository ;

    public TopicService(TopicsRepository topicsRepository){
        this.topicsRepository = topicsRepository ;
    }

    public List<Topic> getTopicsByName(List<String> names){
        return topicsRepository.findAllByNameIn(names) ;
    }
}
