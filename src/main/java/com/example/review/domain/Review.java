package com.example.review.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Review {

    @Id
    @GeneratedValue
    private Long reviewId;
    private Long memberId;
    @Embedded
    private OrderItem orderItem;
    private String reviewDescription;
    private LocalDateTime reviewDate;

    @Enumerated(EnumType.STRING)
    private SatisfactionType satisfactionType;

}
