package com.shivam.qoura.repositories;

import com.shivam.qoura.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer , Long> {
}
