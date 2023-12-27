package com.example.jpapracticeself.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "selfStudy_movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "movie")
    private List<Review> reviewDtoList = new ArrayList<>();

    private String title;
    private String contents;
    private Long score;
}
