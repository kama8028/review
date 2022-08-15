package com.example.review.repository;

import com.example.review.domain.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class ReviewRepository {

    private final EntityManager em;

    public void save(Review review) {
        em.persist(review);
    }

    public Review findOne(Long reviewId) {
        return em.createQuery("select r from Review r where r.reviewId = :reviewId", Review.class)
                .setParameter("reviewId", reviewId).getSingleResult();
    }

    public List<Review> findAllItem(Long orderItemId) {
        return em.createQuery("select r from Review r where r.orderItemId = :orderItemId", Review.class)
                .setParameter("orderItemId", orderItemId).getResultList();
    }

}
