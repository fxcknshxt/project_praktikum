package com.university.campusjobs.controller;

import com.university.campusjobs.entity.Review;
import com.university.campusjobs.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
@Tag(name = "Reviews", description = "Система отзывов")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Operation(summary = "Оставить отзыв")
    @PostMapping
    public ResponseEntity<Review> leaveReview(
            @RequestParam Long applicationId,
            @RequestParam Integer rating,
            @RequestParam String comment) {

        Review review = reviewService.leaveReview(applicationId, rating, comment);
        return ResponseEntity.ok(review);
    }
}