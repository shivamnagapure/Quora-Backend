package com.shivam.qoura.dto.Response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shivam.qoura.models.Topic;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse {

    private Long id ;
    private String title ;
    private String body ;
    private Long userId ;

    @JsonIgnore(value = true)
    private List<String> topics ;

    @JsonIgnore
    private Date createdAt ;

    public QuestionResponse(Long id, String title, String body, Long userId) { // for conversion of Query data into question
        this.id = id;
        this.title = title;
        this.body = body;
        this.userId = userId;
    }
}
