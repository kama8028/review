package com.example.review.controller;

import com.example.review.domain.OrderItem;
import com.example.review.domain.Review;
import com.example.review.domain.SatisfactionType;
import com.example.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")  //CORS 오류를 잡기 위해서 외부 URL 허용을 위한 어노테이션
@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/reviews/orderItem/{orderItemId}")
    public Review findReview(@PathVariable("orderItemId") Long orderItemId) {
        Review myReview = reviewService.findOne(orderItemId);

        return myReview;
    }

    @GetMapping("/reviews/reviewItem/{itemId}")
    public List<ReviewService.ReviewDto> findAllReview(@PathVariable("itemId") Long itemId) {
        //List<Review> reviewItems = reviewService.findAllItem(itemId);
        List<ReviewService.ReviewDto> reviewItems = reviewService.findAllItem(itemId);

        return reviewItems;
    }

    @PostMapping("/reviews")
    public Long review(@RequestBody Review review) {
        System.out.println("한용선");
        System.out.println(review.getMemberId());
        Long reviewId = reviewService.review(review.getMemberId(), review.getOrderItem(), review.getReviewDescription(), review.getSatisfactionType(), review.getReviewDate());
        return reviewId;
    }

    @PutMapping("/reviews")
    public Long updateReview(@RequestBody Review review) {
        System.out.println("리뷰");
        System.out.println(review.getMemberId());
        Long reviewId = reviewService.updateReview(review.getReviewId(), review.getMemberId(), review.getOrderItem(), review.getReviewDescription(), review.getSatisfactionType(), review.getReviewDate());
        return reviewId;
    }

    @DeleteMapping("/reviews/{reviewId}")
    public Long deleteReview(@PathVariable("reviewId") Long reviewId) {
        reviewService.deleteReview(reviewId);

        return reviewId;
    }

}
