package com.example.review;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReviewDeleted extends AbstractEvent{
    private Long orderItemId;
    private Long reviewId;
}
