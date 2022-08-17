package com.example.review.service;

import com.example.review.domain.OrderItem;
import com.example.review.domain.Review;
import com.example.review.domain.SatisfactionType;
import com.example.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Transactional
    public Review findOne(Long orderItemId) {
        return reviewRepository.findOne(orderItemId);
    }

    @Transactional
    public List<Review> findAllItem(Long itemId) {
        return reviewRepository.findAllItem(itemId);
    }

    @Transactional
    public Long review(Long memberId, OrderItem orderItem, String reviewDescription, SatisfactionType satisfactionType, LocalDateTime reviewDate ) {
        Review review = new Review();

        review.setMemberId(memberId);
        review.setOrderItem(orderItem);
        review.setReviewDescription(reviewDescription);
        review.setSatisfactionType(satisfactionType);
        review.setReviewDate(reviewDate);

        reviewRepository.save(review);

        return review.getReviewId();
    }

    @Transactional
    public Long updateReview(Long reviewId, Long memberId, OrderItem orderItem, String reviewDescription, SatisfactionType satisfactionType, LocalDateTime reviewDate ) {
        Review review = new Review();

        review.setReviewId(reviewId);
        review.setMemberId(memberId);
        review.setOrderItem(orderItem);
        review.setReviewDescription(reviewDescription);
        review.setSatisfactionType(satisfactionType);
        review.setReviewDate(reviewDate);

        reviewRepository.update(review);

        return review.getReviewId();
    }

    @Transactional
    public Long deleteReview(Long reviewId) {
        reviewRepository.delete(reviewId);
        return reviewId;
    }

}
