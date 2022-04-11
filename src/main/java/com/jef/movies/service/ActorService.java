package com.jef.movies.service;

import com.jef.movies.entity.Actor;
import com.jef.movies.repository.ActorRepository;
import com.jef.movies.repository.ActorRepositoryCriteria;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ActorService {
    private ActorRepository actorRepository;
    private ActorRepositoryCriteria actorRepositoryCriteria;

    public List<Actor> getActorWithFirstNamePrefix(String prefixFirstName) {
        return actorRepositoryCriteria.getActorWithFirstNamePrefix(prefixFirstName);
    }

    public List<Actor> getActorsGreaterThanRating(double rating) {
        return actorRepository.findActorsByRatingGreaterThanEqual(rating);
    }

    public List<Actor> getActorsByMovie(String movie) {
//        return actorRepository.findByMovies_title(movie);
//        return actorRepository.findAllActorsByMoviesTitle(movie);
        return actorRepository.findAllActors_UsingMovieTitle(movie);
    }
}
