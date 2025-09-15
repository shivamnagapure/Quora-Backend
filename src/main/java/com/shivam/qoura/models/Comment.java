package com.shivam.qoura.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment extends BaseModel{
    @ManyToOne
    Comment parentId ; //one parent can have many child comments

    @Column(nullable = false)
    private  String text ;

    @ManyToOne
    User user ; //one user can have multiple comments
}
