package com.university.campusjobs.service;

import com.university.campusjobs.entity.Review;
import com.university.campusjobs.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review leaveReview(Long applicationId, Integer rating, String comment) {
        Review review = new Review();
        review.setRating(rating);
        review.setComment(comment);
        review.setType("STUDENT_TO_EMPLOYER");
        return reviewRepository.save(review);
    }
}