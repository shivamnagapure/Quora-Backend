package com.shivam.qoura.adapters;

import com.shivam.qoura.dto.Request.CommentRequest;
import com.shivam.qoura.models.Comment;

public interface CommentReqToComment {

    Comment covertTocomment(CommentRequest commentRequest);
}
