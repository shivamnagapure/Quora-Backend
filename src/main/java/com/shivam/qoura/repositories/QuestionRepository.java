package com.shivam.qoura.repositories;

import com.shivam.qoura.dto.Response.QuestionResponse;
import com.shivam.qoura.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question , Long> {

    //search by title/body containing tag/text

    @Query("SELECT new com.shivam.qoura.dto.Response.QuestionResponse(" +
            "b.id, b.title, b.body, u.id) " +
            "FROM Question b " +
            "JOIN b.user u " +
            "WHERE (:text IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :text, '%')) " +
            "   OR LOWER(b.body) LIKE LOWER(CONCAT('%', :text, '%'))) " +
            "AND (:tag IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :tag, '%')) " +
            "   OR LOWER(b.body) LIKE LOWER(CONCAT('%', :tag, '%')))")
    List<QuestionResponse> searchQuestions(@Param("text") String text, @Param("tag") String tag);





}
