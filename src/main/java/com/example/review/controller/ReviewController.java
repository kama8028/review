package com.example.review.controller;

import com.example.review.domain.OrderItem;
import com.example.review.domain.Review;
import com.example.review.domain.SatisfactionType;
import com.example.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin(origins = "*", allowedHeaders = "*")  //CORS 오류를 잡기 위해서 외부 URL 허용을 위한 어노테이션
@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/reviews")
    public Long review(@RequestBody Review review) {
        System.out.println("한용선");
        System.out.println(review.getMemberId());
        Long reviewId = reviewService.review(review.getMemberId(), review.getOrderItem(), review.getReviewDescription(), review.getSatisfactionType(), review.getReviewDate());
        return reviewId;
    }

}
