package com.example.review.repository;

import com.example.review.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberItemRepository extends JpaRepository<OrderItem, Long> {
}
