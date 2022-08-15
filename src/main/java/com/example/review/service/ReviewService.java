package com.example.review.service;

import com.example.review.domain.OrderItem;
import com.example.review.domain.Review;
import com.example.review.domain.SatisfactionType;
import com.example.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

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

}
