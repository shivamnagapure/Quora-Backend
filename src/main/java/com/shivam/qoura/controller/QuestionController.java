package com.shivam.qoura.controller;

import com.shivam.qoura.adapters.QueReqToQue;
import com.shivam.qoura.dto.Request.QuestionRequest;
import com.shivam.qoura.models.Question;
import com.shivam.qoura.service.QuestionService;
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
        Question question = queReqToQue.convertToQuestion(questionRequest);
        Question questionSaved = questionService.saveQuestion(question);

        return ResponseEntity.status(HttpStatus.CREATED).body(questionSaved);

    }
}
