package com.shivam.qoura.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "questions")
public class Question extends BaseModel{

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false )
    User user ; //Many questions can have one user

    @ManyToMany
    @JoinTable(
            name = "questions_topics",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id")
    )
    List<Topic> topics ; // A question can have many topics, and a topic can belong to many questions
}
