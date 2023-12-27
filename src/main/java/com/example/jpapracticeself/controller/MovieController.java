package com.example.jpapracticeself.controller;

import com.example.jpapracticeself.model.Movie;
import com.example.jpapracticeself.model.MovieDto;
import com.example.jpapracticeself.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/practice/movie")
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity createMovie(MovieDto movieDto) {
        movieService.createMovie(movieDto);
        return ResponseEntity.ok().body("Movie 생성 성공");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity findMovieList() {
        List<MovieDto> movieDtos = movieService.findMovieList();
        return ResponseEntity.ok().body(movieDtos);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/find")
    public ResponseEntity findMovieById(Integer id) {
        MovieDto movieDto = movieService.findMovieById(id);
        return ResponseEntity.ok().body(movieDto);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity updateMovie(Integer id, MovieDto movieDto) {
        movieService.updateMovie(id, movieDto);
        return ResponseEntity.ok().body("Movie 수정 완료");

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity deleteMovie(Integer id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok().body("Movie 삭제 완료");
    }
}
