package com.shivam.qoura.adapters;

import com.shivam.qoura.dto.Request.CommentRequest;
import com.shivam.qoura.models.Answer;
import com.shivam.qoura.models.Comment;
import com.shivam.qoura.models.User;
import com.shivam.qoura.service.AnswerService;
import com.shivam.qoura.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CommentReqToCommentImpl implements CommentReqToComment{

    UserService userService ;
    AnswerService answerService ;

    public CommentReqToCommentImpl(UserService userService , AnswerService answerService ){
        this.userService = userService ;
        this.answerService = answerService ;
    }

    @Override
    public Comment covertTocomment(CommentRequest commentRequest) {
        User user = userService.findUserById(commentRequest.getUserId());
        return Comment.builder()
                .text(commentRequest.getText())
                .user(user)
                .build();


    }


}
