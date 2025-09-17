package com.shivam.qoura.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comment extends BaseModel{
    @ManyToOne
    Comment parentComment ; //one parent can have many child comments

    @ManyToOne
    Answer answer ; //one answer can have many comments

    @Column(nullable = false)
    private  String text ;

    @ManyToOne
    User user ; //one user can have multiple comments
}
