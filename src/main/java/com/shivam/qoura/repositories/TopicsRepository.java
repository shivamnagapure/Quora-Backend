package com.shivam.qoura.repositories;

import com.shivam.qoura.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TopicsRepository extends JpaRepository<Topic , Long> {

    List<Topic> findAllByNameIn(List<String> names) ;

}
