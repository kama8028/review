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

    @ManyToOne
    private Member member;

    @OneToOne
    private OrderItem orderItem;
    private String reviewTitle;
    private String reviewDescription;
    private LocalDateTime reviewDate;
    private SatisfactionType satisfactionType;


}
