package com.shivam.qoura.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Answer extends BaseModel{

    @Column(nullable = false)
    private String text ;

    @ManyToOne
    Question question ; //one question can have many answers

    @ManyToOne
    User user ; //many answers can belong to one user
}
