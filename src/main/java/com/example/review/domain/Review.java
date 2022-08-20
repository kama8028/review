package com.example.review.domain;

import com.example.review.ReviewDeleted;
import com.example.review.ReviewWritten;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

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

    @PostPersist
    public void onPostPersist(){
       System.out.println("onPostPersist 진입");
       ReviewWritten reviewWritten = new ReviewWritten();
       reviewWritten.setOrderItemId(this.orderItem.getOrderItemId());
       reviewWritten.setReviewId(this.getReviewId());
       reviewWritten.publishAfterCommit();
    }

    @PostRemove
    public void onPostRemove(){
        System.out.println("onPostRemove 진입");
        ReviewDeleted reviewDeleted = new ReviewDeleted();
        reviewDeleted.setOrderItemId(this.orderItem.getOrderItemId());
        reviewDeleted.setReviewId(this.getReviewId());
        reviewDeleted.publishAfterCommit();
    }

}
