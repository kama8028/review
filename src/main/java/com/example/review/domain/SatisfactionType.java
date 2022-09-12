package com.example.review.domain;

import lombok.Getter;

@Getter
public enum SatisfactionType {
    GOOD("좋아요!!"), NORMAL("보통이에요!!"), BAD("별로에요ㅠㅠ");
    private final String value;

    SatisfactionType(String value) {this.value=value;}
}
