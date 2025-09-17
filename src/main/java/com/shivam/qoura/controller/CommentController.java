package com.shivam.qoura.controller;

import com.shivam.qoura.adapters.CommentReqToComment;
import com.shivam.qoura.dto.Request.AnswerRequest;
import com.shivam.qoura.dto.Request.CommentRequest;
import com.shivam.qoura.dto.Response.CommentResponse;
import com.shivam.qoura.models.Answer;
import com.shivam.qoura.models.Comment;
import com.shivam.qoura.service.AnswerService;
import com.shivam.qoura.service.CommentService;
import com.shivam.qoura.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    CommentReqToComment commentReqToComment ;
    AnswerService answerService ;
    CommentService commentService ;


    public CommentController(CommentReqToComment commentReqToComment , AnswerService answerService , CommentService commentService){
        this.commentReqToComment = commentReqToComment ;
        this.answerService = answerService ;
        this.commentService = commentService ;

    }

    @PostMapping("answers/{answerId}/comments")
    public ResponseEntity<?> commentOnAnswer(@PathVariable("answerId") Long answerId ,
                                             @RequestBody CommentRequest commentRequest){
        Answer answer = answerService.findAnswerById(answerId);
        Comment comment = commentReqToComment.covertTocomment(commentRequest);

        //set answerId
        comment.setAnswer(answer);

        Comment saveComment = commentService.addComment(comment);
        CommentResponse response = Response.commentResponse(saveComment) ;

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
