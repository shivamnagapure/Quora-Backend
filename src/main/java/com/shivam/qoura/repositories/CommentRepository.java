package com.shivam.qoura.repositories;

import com.shivam.qoura.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment , Long> {
}
