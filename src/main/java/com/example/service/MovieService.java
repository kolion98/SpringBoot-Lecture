package com.example.service;

import com.example.domain.entity.Movie;
import com.example.domain.request.MovieRequest;
import com.example.domain.response.MovieResponse;
import com.example.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final LogService logService;

    @Transactional
    public MovieResponse getMovie(long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        return MovieResponse.of(movie);
    }

    @Transactional
    public List<MovieResponse> getMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map(MovieResponse::of).toList();
    }

    @Transactional
    public boolean saveMovie(MovieRequest movieRequest) {
        Movie movie = new Movie(movieRequest.getName(), movieRequest.getProductionYear());
        movieRepository.save(movie);
        logService.saveLog();
        return true;
    }

    @Transactional
    public void updateMovie(long movieId, MovieRequest movieRequest)  {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        movie.setName("변경1");
        movie.setName("변경2");
        movie.setName("변경3");
        movie.setName("아이언맨");
    }

    @Transactional
    public void removeMovie(long movieId)  {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        movieRepository.delete(movie);
    }
}
