package com.jef.movies.service;

import com.jef.movies.entity.Actor;
import com.jef.movies.repository.ActorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ActorService {
    private ActorRepository actorRepository;

    public List<Actor> getActorsGreaterThanRating(double rating) {
        return actorRepository.findActorsByRatingGreaterThanEqual(rating);
    }
}
