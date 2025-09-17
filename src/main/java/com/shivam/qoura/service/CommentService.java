package com.shivam.qoura.service;

import com.shivam.qoura.models.Comment;
import com.shivam.qoura.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    CommentRepository commentRepository ;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public Comment addComment(Comment comment){
        return commentRepository.save(comment);
    }

}
