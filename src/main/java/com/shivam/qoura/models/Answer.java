package com.shivam.qoura.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "answers")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Answer extends BaseModel {

    @Column(nullable = false)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
