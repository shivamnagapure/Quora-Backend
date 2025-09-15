package com.shivam.qoura.adapters;

import com.shivam.qoura.dto.Request.QuestionRequest;
import com.shivam.qoura.models.Question;

public interface QueReqToQue {

    Question convertToQuestion(QuestionRequest questionRequest);
}
