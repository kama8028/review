package com.example.review;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReviewWritten extends AbstractEvent{

    private Long orderItemId;
    private Long reviewId;
}
