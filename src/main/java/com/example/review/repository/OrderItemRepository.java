package com.example.review.repository;

import com.example.review.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<Member, Long> {
}
