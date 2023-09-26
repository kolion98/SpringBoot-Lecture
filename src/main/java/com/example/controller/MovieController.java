package com.example.controller;

import com.example.common.Response;
import com.example.domain.entity.Movie;
import com.example.domain.request.MovieRequest;
import com.example.domain.response.MovieResponse;
import com.example.service.MovieService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "무비 컨트롤러다")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class MovieController {
    private final MovieService movieService;

//    @Deprecated(since = "v2 사용하세요")
//    @GetMapping("/v1/movies")
//    public String getMovies() {
//        return "test";
//    }

//    @GetMapping("/v2/movies")
//    public List<Movie> getMovies2() {
//        return List.of(new Movie(1, "오펜하이머", 2023));
//    }

    @GetMapping("/v1/movies")
    public Response<List<MovieResponse>> getMovies(
            @RequestParam(value = "overYear", required = false) Integer overYear
    ) {
        return Response.of(movieService.getMovies());
    }

    @GetMapping("/v1/movies/{movieId}")
    public Response<MovieResponse> getMovie(
            @PathVariable(value = "movieId") long movieId
    ) {
        return Response.of(movieService.getMovie(movieId));
    }

    @PostMapping("/v1/movies")
    public void saveMovie(@RequestBody MovieRequest movieRequest) {
        movieService.saveMovie(movieRequest);
    }

    @PutMapping("/v1/movies/{movieId}")
    public void updateMovie(
            @PathVariable(value = "movieId") long movieId,
            @RequestBody MovieRequest movieRequest
    )  {
        movieService.updateMovie(movieId, movieRequest);
    }

    @DeleteMapping("/v1/movies/{movieId}")
    public void removeMovie(
            @PathVariable(value = "movieId") long movieId
    )  {
        movieService.removeMovie(movieId);
    }
}
