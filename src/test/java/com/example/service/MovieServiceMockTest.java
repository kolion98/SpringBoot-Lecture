package com.example.service;

import com.example.domain.entity.Actor;
import com.example.domain.entity.Director;
import com.example.domain.entity.Movie;
import com.example.domain.request.MovieRequest;
import com.example.domain.response.MovieResponse;
import com.example.repository.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieServiceMockTest {
    @Mock
    private MovieRepository movieRepository;

    @Mock
    private LogService logService;

    @InjectMocks
    MovieService movieService;

    @Test
    public void 영화단건조회_정상조회_테스트() {
        // given
        int movieId = 1;
        Movie movie = new Movie();
        movie.setDirector(new Director());
        movie.setActors(List.of(new Actor()));

        //when
        when(movieRepository.findById(anyLong())).thenReturn(Optional.of(movie));

        // then
        MovieResponse result = movieService.getMovie(movieId);
        assertNotNull(result);
    }

    @Test
    public void 영화단건조회_불가_테스트() {
        // given
        int movieId = 1;
        Movie movie = new Movie();
        movie.setDirector(new Director());
        movie.setActors(List.of(new Actor()));

        // when
        when(movieRepository.findById(anyLong())).thenReturn(null);

        // then
        assertThrows(NullPointerException.class, () -> movieService.getMovie(movieId));
    }

    @Test
    public void 영화다건조회_정상조회_테스트() {

        Movie movie = new Movie();
        movie.setDirector(new Director());
        movie.setActors(List.of(new Actor()));

        List<Movie> movies = new ArrayList<>();
        movies.add(movie);
        movies.add(movie);
        movies.add(movie);

        when(movieRepository.findAll()).thenReturn(movies);

        assertNotNull(movieService.getMovies());
    }

    @Test
    public void 영화다건조회_불가_테스트() {

        Movie movie = new Movie();
        movie.setDirector(new Director());
        movie.setActors(List.of(new Actor()));

        List<Movie> movies = new ArrayList<>();
        movies.add(movie);
        movies.add(movie);
        movies.add(movie);

        when(movieRepository.findAll()).thenReturn(null);

        assertThrows(NullPointerException.class, () -> movieService.getMovies());
    }
    
    @Test
    public void 영화저장_정상저장_테스트() {

        Movie movie = new Movie();
        movie.setProductionYear(0);

        MovieRequest movieRequest = new MovieRequest(
                movie.getId(),
                movie.getName(),
                movie.getProductionYear()
        );

        when(movieRepository.save(any(Movie.class))).thenReturn(movie);
        doNothing().when(logService).saveLog();

        assertTrue(movieService.saveMovie(movieRequest));
    }

//    @Test
//    public void 영화저장_불가_테스트() {
//        Movie movie = new Movie();
//        movie.setProductionYear(0);
//
//        MovieRequest movieRequest = new MovieRequest(
//                movie.getId(),
//                movie.getName(),
//                movie.getProductionYear()
//        );
//
//        when(movieRepository.save(any(Movie.class)))..thenReturn();
//        doNothing().when(logService).saveLog();
//
//        assertFalse(movieService.saveMovie(movieRequest));
//    }
//
//    @Test
//    public void 영화업뎃_정상업뎃_테스트() {
//        MovieRequest movieRequest = new MovieRequest(0,"name", 2000);
//
//        // given
//        int movieId = 1;
//        Movie movie = new Movie();
//        movie.setDirector(new Director());
//        movie.setActors(List.of(new Actor()));
//
//        //when
//        when(movieRepository.findById(anyLong())).thenReturn(Optional.of(movie));
//
//        // then
//        MovieResponse result = movieService.getMovie(movieId);
//        assertNotNull(result);
//    }
//
//    @Test
//    public void 영화업뎃_불가_테스트() {
//
//    }
//
//    @Test
//    public void 영화삭제_정상삭제_테스트() {
//
//    }
//
//    @Test
//    public void 영화삭제_불가_테스트() {
//
//    }
}
