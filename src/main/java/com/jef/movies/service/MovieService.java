package com.jef.movies.service;

import com.jef.movies.entity.Movie;
import com.jef.movies.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

    private MovieRepository movieRepository;

    public List<Movie> getMoviesByActorRating(double rating) {
//        return movieRepository.findAllByActorsRatingGreaterThanEqual(rating);
        return movieRepository.findAllWithActorsRatingGreaterThanEqual(rating);
    }

    public List<Movie> getMoviesByGenreName(String genre_name) {
        return movieRepository.findAllByGenreName(genre_name);
    }

}

