package com.example.jpapracticeself.service;

import com.example.jpapracticeself.model.Movie;
import com.example.jpapracticeself.model.MovieDto;
import com.example.jpapracticeself.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void createMovie(MovieDto movieDto) {
        // movieDto -> movie Entity로 변경해야 함.
        movieRepository.save(Movie.builder()
                .title(movieDto.getTitle())
                .contents(movieDto.getContents())
                .score(movieDto.getScore())
                .build());
    }

    public List<MovieDto> findMovieList() {
        // db에서 조회한 MovieList는 Movie Entity
        // => Movie -> MovieDto로 바꿔주어야 함.

        List<Movie> movies = movieRepository.findAll();
        List<MovieDto> movieDtos = new ArrayList<>();

        for (Movie movie : movies) {
            MovieDto movieDto = MovieDto.builder()
                    .title(movie.getTitle())
                    .contents(movie.getContents())
                    .score(movie.getScore())
                    .build();
            movieDtos.add(movieDto);
        }
        return movieDtos;
    }

    public MovieDto findMovieById(Integer id) {
        Optional<Movie> result = movieRepository.findById(id);
        Movie movie = result.get();

        MovieDto movieDto = MovieDto.builder()
                .title(movie.getTitle())
                .contents(movie.getContents())
                .score(movie.getScore())
                .build();
        return movieDto;
    }

    public void updateMovie(Integer id, MovieDto movieDto) {
        // findById()로 결과 하나 조회하고
        // 그 결과는 Entity인데
        // 입력받은 MovieDto를 Movie에 저장해야 함.

        Optional<Movie> result = movieRepository.findById(id);
        Movie movie = result.get();

        if (result.isPresent()) {
            movie.setTitle(movieDto.getTitle());
            movie.setContents(movieDto.getContents());
            movie.setScore(movieDto.getScore());
            movieRepository.save(movie);
        }
    }

    public void deleteMovie(Integer id) {
        movieRepository.delete(Movie.builder().id(id).build());
    }
}
