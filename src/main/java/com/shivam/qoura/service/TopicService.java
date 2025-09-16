package com.shivam.qoura.service;

import com.shivam.qoura.models.Topic;
import com.shivam.qoura.repositories.TopicsRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.LocalTime.now;

@Service
public class TopicService {

    TopicsRepository topicsRepository ;

    EntityManager entityManager ;

    private static final int BATCH_SIZE = 500;

    public TopicService(TopicsRepository topicsRepository , EntityManager entityManager){
        this.topicsRepository = topicsRepository ;
        this.entityManager = entityManager ;
    }

    @Transactional
    public List<Topic> getTopicsByName(List<String> names){
        /*
            Problem : Topics may or may not exist in database
            Solution : We have to add topics which are not present in database
            Implementation ;
                1. fetch given topic from database , those topics are not present in fetched topics add them one by one
                -> leads to n + 1 one queries or have to execute multiple queries
                -> leads to concurrency problem or race condition

         */
        System.out.println("LIst is Empty");
        if (names == null || names.isEmpty()) {
            return Collections.emptyList();
        }
        System.out.println("LIst is Empty");
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // Split into Batches
        for(int i = 0 ; i < names.size() ; i += BATCH_SIZE ){
            List<String> batch = names.subList(i , Math.min( i + BATCH_SIZE , names.size()));

            System.out.println(batch);
            String values = batch.stream()
                    .map(name -> "('" + name.replace("'", "''")+ "', '" + now  + "')")
                    .collect(Collectors.joining(", "));
            System.out.println(values);

            String sql = "INSERT IGNORE INTO topic(name , created_at ) VALUES " + values;
            entityManager.createNativeQuery(sql).executeUpdate();
        }

        // Fetch all topics (existing + newly inserted)
        return topicsRepository.findAllByNameIn(names);

    }
}
