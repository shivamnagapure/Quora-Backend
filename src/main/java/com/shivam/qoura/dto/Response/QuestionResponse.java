package com.shivam.qoura.dto.Response;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private List<String> topics ;

    @JsonIgnore
    private Date createdAt ;


}
