package com.example.service;

import com.example.domain.entity.Movie;
import com.example.domain.request.MovieRequest;
import com.example.domain.response.MovieResponse;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private static List<Movie> movies = new ArrayList<>();

    @PostConstruct
    public void init() {
        movies.addAll(List.of(
                new Movie(1, "인셉션", 2014, LocalDateTime.now()),
                new Movie(2, "해리포터", 2021, LocalDateTime.now()),
                new Movie(3, "아이언맨", 2020, LocalDateTime.now())
        ));
    }

    public List<MovieResponse> getMovie() {
//        return movies.stream().map(movie ->
//                MovieResponse.builder()
//                        .id(movie.getId())
//                        .name(movie.getName())
//                        .productionYear(movie.getProductionYear())
//                        .build()
//        ).toList();
        return movies.stream().map(MovieResponse::of).toList();
    }

    public Movie getMovie(long movieId) {
        return movies.stream()
                .filter(movie -> movie.getId() == movieId)
                .toList()
                .stream()
                .findFirst()
                .orElseThrow();
    }

    public void createMovie(MovieRequest movieRequest) {
        Movie movie = new Movie(
                movies.size()+1,
                movieRequest.getName(),
                movieRequest.getProductionYear(),
                LocalDateTime.now()
        );
        movies.add(movie);
    }

    public void updateMovie(long movieId, MovieRequest movieRequest)  {
        Movie movie = getMovie(movieId);
        movie.setName(movieRequest.getName());
        movie.setProductionYear(movieRequest.getProductionYear());
    }

    public void deleteMovie(long movieId)  {
        Movie movie = getMovie(movieId);
        movies.remove(movie);
    }
}
