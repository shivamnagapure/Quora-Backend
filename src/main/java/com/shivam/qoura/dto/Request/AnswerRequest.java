package com.shivam.qoura.dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerRequest {

    private Long userId ;
    private Long questionId ;
    private String text ;

}
