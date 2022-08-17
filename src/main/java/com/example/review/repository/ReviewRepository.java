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

    public void update(Review review) {
        em.merge(review);
    }

    public void delete(Long reviewId) {
        Review review = em.find(Review.class, reviewId);
        em.remove(review);
    }

    public Review findOne(Long orderItemId) {
        return em.createQuery("select r from Review r where r.orderItem.orderItemId = :orderItemId", Review.class)
                .setParameter("orderItemId", orderItemId).getSingleResult();
    }

    public List<Review> findAllItem(Long itemId) {
        return em.createQuery("select r from Review r where r.orderItem.itemId = :itemId", Review.class)
                .setParameter("itemId", itemId).getResultList();
    }

}
