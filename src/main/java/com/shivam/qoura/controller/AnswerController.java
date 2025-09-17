package com.shivam.qoura.controller;

import com.shivam.qoura.adapters.AnsReqToAnswer;
import com.shivam.qoura.dto.Request.AnswerRequest;
import com.shivam.qoura.dto.Response.AnswerResponse;
import com.shivam.qoura.models.Answer;
import com.shivam.qoura.service.AnswerService;
import com.shivam.qoura.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    AnswerService answerService ;

    AnsReqToAnswer ansReqToAnswer ;

    public AnswerController(AnswerService answerService , AnsReqToAnswer ansReqToAnswer){
        this.answerService = answerService ;
        this.ansReqToAnswer = ansReqToAnswer ;
    }

    @PostMapping("/{questionId}/answers")
    public ResponseEntity<?> postAnswer(@PathVariable("questionId") Long questionId,
            @RequestBody AnswerRequest answerRequest){
        //set question id
        answerRequest.setQuestionId(questionId);
        //conversion of post answerReq To Answer
        Answer convertToAns = ansReqToAnswer.convertToAnswer(answerRequest);
        Answer answer = answerService.saveAnswer(convertToAns);
        AnswerResponse response = Response.answerResponse(answer);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
