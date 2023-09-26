package com.example.service;

import com.example.domain.entity.Director;
import com.example.domain.entity.Log;
import com.example.domain.entity.Movie;
import com.example.domain.request.MovieRequest;
import com.example.domain.response.MovieResponse;
import com.example.repository.LogRepository;
import com.example.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final LogService logService;
    private final LogRepository logRepository;
//    private final EntityManagerFactory emf;
//
//    @PostConstruct
//    public void init() {
//        movies.addAll(List.of(
//                new Movie(1, "인셉션", 2014, LocalDateTime.now()),
//                new Movie(2, "해리포터", 2021, LocalDateTime.now()),
//                new Movie(3, "아이언맨", 2020, LocalDateTime.now())
//        ));
//    }

    @Transactional
    public MovieResponse getMovie(long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        return MovieResponse.of(movie);
    }

    @Transactional
    public List<MovieResponse> getMovies() {
        //List<Movie> movies = movieRepository.findAll();
        //List<Movie> movies = movieRepository.findAllJpqlFetch();
        List<Movie> movies = movieRepository.findByProductionYear(2022);
        return movies.stream().map(MovieResponse::of).toList();
    }

//**tx 전파옵션 공부해보기**
    @Transactional
    public void saveMovie(MovieRequest movieRequest) {
        Movie movie = new Movie(movieRequest.getName(), movieRequest.getProductionYear());
        movieRepository.save(movie);
//        Movie movie1 = new Movie(movieRequest.getName() + "1", movieRequest.getProductionYear());
//        Movie movie2 = new Movie(movieRequest.getName() + "2", movieRequest.getProductionYear());
//        Movie movie3 = new Movie(movieRequest.getName() + "3", movieRequest.getProductionYear());
//        movieRepository.save(movie1);
//        movieRepository.save(movie2);
//        movieRepository.save(movie3);
//        movieRepository.saveAll(List<Movie>~~); // 여러개 하는 경우

        logService.saveLog();
        //saveLog();  //틀린 예시
        //throw new RuntimeException("강제 에러");

        // save가 에러나서 rollback은 되는데, log를 남기고 싶다면? 아래와 *유사한* 동작
        // 근데 매번 로그를 만들어서 해야하네? -> LogService 주입!, propagation 주기 - Propagation.REQUIRES_NEW
//        try {
//            movieRepository.save(movie);
//            Log log = new Log(); //"이건 성공로그"
//            logRepository.save(log);
////            throw new RuntimeException("뭔가 에러가 발생했어");
////            if(movie != null) {
////                throw new RuntimeException("뭔가 에러가 발생했어");
////            }
//        } catch(Exception e) {
//            Log log = new Log(); //"이건 실패로그"
//            logRepository.save(log);
//        }
    }
    @Transactional //안붙이면 처음에 조회만 됨
    public void updateMovie(long movieId, MovieRequest movieRequest)  {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        movie.setName("변경1");
        movie.setName("변경2");
        movie.setName("변경3");
        movie.setName("아이언맨");
        //쓰기 지연 현상 발생 -> merge만 하고 쌓아두다가 마지막 변경3에 와서 commit이 일어남(JPA의 효과!)
    }

    @Transactional
    public void removeMovie(long movieId)  {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        movieRepository.delete(movie);
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)  //틀린 예시 -
    public void saveLog() {
        logRepository.save(new Log());
    }
}
