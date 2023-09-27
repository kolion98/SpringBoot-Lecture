package com.example.domain.response;

import com.example.domain.entity.Actor;
import com.example.domain.entity.Movie;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Builder
@Getter
public class MovieResponse {
    private final Long id; //long
    private final String name;
    private final Integer productionYear;
    private final String directorName;
    private final List<String> actorNames;

    public static MovieResponse of(Movie entity) {
        return new MovieResponse(
                entity.getId(),
                entity.getName(),
                entity.getProductionYear(),
                entity.getDirector().getName(),
                entity.getActors().stream().map(Actor::getName).toList()
        );
    }
}
