package com.shivam.qoura.controller;

import com.shivam.qoura.adapters.QueReqToQue;
import com.shivam.qoura.dto.Request.QuestionRequest;
import com.shivam.qoura.dto.Response.QuestionResponse;
import com.shivam.qoura.models.Question;
import com.shivam.qoura.service.QuestionService;
import com.shivam.qoura.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        QuestionResponse response = Response.questionResponse(questionSaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<?>> getQuestions(@RequestParam(required = false) String text ,
                                             @RequestParam(required = false) String tag){
        List<QuestionResponse>  questionList = questionService.searchQuestions(text, tag);
        return ResponseEntity.ok().body(questionList);
    }
}
