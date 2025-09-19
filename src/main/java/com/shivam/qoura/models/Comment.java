package com.shivam.qoura.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "comments")
public class Comment extends BaseModel{
    @JoinColumn(name = "parent_comment_id")
    @ManyToOne
    Comment parentComment ; //one parent can have many child comments

    @JoinColumn(name = "answer_id ")
    @ManyToOne
    Answer answer ; //one answer can have many comments

    @Column(nullable = false)
    private  String text ;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    User user ; //one user can have multiple comments
}
