package com.shivam.qoura.repositories;

import com.shivam.qoura.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like , Long> {
}
