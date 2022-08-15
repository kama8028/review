package com.example.review.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
public class OrderItem {

    private Long orderItemId;
    private Long itemId;
    private String itemName;

}
