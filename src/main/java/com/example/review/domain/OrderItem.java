package com.example.review.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class OrderItem {

    @Id
    @GeneratedValue
    private Long id;
    private Long orderItemId;
    private String Name;

}
