package com.university.campusjobs.repository;

import com.university.campusjobs.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}