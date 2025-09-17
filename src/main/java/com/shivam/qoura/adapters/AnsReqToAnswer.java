package com.shivam.qoura.adapters;

import com.shivam.qoura.dto.Request.AnswerRequest;
import com.shivam.qoura.models.Answer;

public interface AnsReqToAnswer {
    Answer convertToAnswer(AnswerRequest answerRequest);
}
