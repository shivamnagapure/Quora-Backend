package com.shivam.qoura.controller;

import com.shivam.qoura.adapters.QueReqToQue;
import com.shivam.qoura.dto.Request.QuestionRequest;
import com.shivam.qoura.dto.Response.QuestionResponse;
import com.shivam.qoura.models.Question;
import com.shivam.qoura.service.QuestionService;
import com.shivam.qoura.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    QuestionService questionService ;

    QueReqToQue queReqToQue ;

    public QuestionController(QuestionService questionService , QueReqToQue queReqToQue){
        this.questionService = questionService ;
        this.queReqToQue = queReqToQue ;
    }

    @PostMapping
    public ResponseEntity<?> addQuestion(@RequestBody QuestionRequest questionRequest){
        System.out.println(questionRequest.getTopics());
        Question question = queReqToQue.convertToQuestion(questionRequest);
        System.out.println("queReqToQue");
        Question questionSaved = questionService.saveQuestion(question);
        System.out.println("questionService");
        QuestionResponse response = Response.questionResponse(questionSaved);
        System.out.println(response.getTopics());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
}
