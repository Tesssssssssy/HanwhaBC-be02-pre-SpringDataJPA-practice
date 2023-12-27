package com.example.jpapracticeself.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MovieDto {
    String title;
    String contents;
    Long score;
    List<Review> reviewDtoList;
}
