package com.example.jpapracticeself.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewDto {
    private String title;
    private String contents;
    private Integer star;
}
