package com.shivam.qoura.repositories;

import com.shivam.qoura.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question , Long> {
}
