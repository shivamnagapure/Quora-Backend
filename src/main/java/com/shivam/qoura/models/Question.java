package com.shivam.qoura.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Question extends BaseModel{

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body ;

    @ManyToOne
    User user ; //Many questions can have one user

    @ManyToMany
    @JoinTable(
            name = "questions_topics",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id")
    )
    List<Topic> topics ; // A question can have many topics, and a topic can belong to many questions
}
