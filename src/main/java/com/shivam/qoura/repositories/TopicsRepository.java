package com.shivam.qoura.repositories;

import com.shivam.qoura.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicsRepository extends JpaRepository<Topic , Long> {

    public List<Topic> findAllByNameIn(List<String> names) ;
}
