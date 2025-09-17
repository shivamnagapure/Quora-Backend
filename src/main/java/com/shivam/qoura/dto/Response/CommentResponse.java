package com.shivam.qoura.dto.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentResponse {
    private Long id ;
    private String userName ;
    private String answer ;
    private String comment ;
    private String text ;

}
