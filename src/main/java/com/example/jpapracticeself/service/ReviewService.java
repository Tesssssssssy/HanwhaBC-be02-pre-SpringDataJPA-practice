package com.example.jpapracticeself.service;

import com.example.jpapracticeself.model.Movie;
import com.example.jpapracticeself.model.MovieDto;
import com.example.jpapracticeself.model.Review;
import com.example.jpapracticeself.model.ReviewDto;
import com.example.jpapracticeself.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void createReview(Integer id, ReviewDto reviewDto) {

    }

    public void findReviewList() {

    }

    public void findReviewById(Integer id) {

    }

    public void updateReview(Integer id, ReviewDto reviewDto) {

    }

    public void deleteReview(Integer id) {

    }
}
