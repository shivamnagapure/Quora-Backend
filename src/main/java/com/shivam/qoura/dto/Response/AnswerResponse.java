package com.shivam.qoura.dto.Response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AnswerResponse {
    private Long answerId ;
    private Long userId ;
    private Long questionId ;
    private String text ;
}
