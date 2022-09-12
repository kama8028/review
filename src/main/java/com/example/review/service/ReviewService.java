package com.example.review.service;

import com.example.review.domain.OrderItem;
import com.example.review.domain.Review;
import com.example.review.domain.SatisfactionType;
import com.example.review.repository.ReviewRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Transactional
    public Review findOne(Long orderItemId) {
        return reviewRepository.findOne(orderItemId);
    }

/*    @Transactional
    public List<Review> findAllItem(Long itemId) {


        List<ReviewDto> review = reviewRepository.findAllItem(itemId).stream().map(m -> new ReviewDto(m)).collect(Collectors.toList());
//        List<Review> review = reviewRepository.findAllItem(itemId);
//        List<Review> review = new ArrayList<>();

        //return reviewRepository.findAllItem(itemId);
        return review;
    }*/

    @Transactional
    public List<ReviewDto> findAllItem(Long itemId) {


        List<ReviewDto> review = reviewRepository.findAllItem(itemId).stream().map(m -> new ReviewDto(m)).collect(Collectors.toList());
//        List<Review> review = reviewRepository.findAllItem(itemId);
//        List<Review> review = new ArrayList<>();

        //return reviewRepository.findAllItem(itemId);
        return review;
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

    @Getter
    public class ReviewDto {

        private Long reviewId;
        private Long memberId;
        private OrderItem orderItem;
        private String reviewDescription;
        private LocalDateTime reviewDate;
        private String satisfactionType;

        public ReviewDto(Review review) {
            reviewId = review.getReviewId();
            memberId = review.getMemberId();
            orderItem = review.getOrderItem();
            reviewDescription = review.getReviewDescription();
            reviewDate = review.getReviewDate();
            satisfactionType = review.getSatisfactionType().getValue();
            System.out.println(satisfactionType);
        }
    }

}
