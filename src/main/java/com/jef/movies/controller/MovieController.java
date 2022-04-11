package com.jef.movies.controller;

import com.jef.movies.dto.MovieDTO;
import com.jef.movies.entity.Movie;
import com.jef.movies.repository.MovieRepository;
import com.jef.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/filter-by-actor-rating")
    public ResponseEntity<List<MovieDTO>> getMoviesByActorRating(@RequestParam("actor_rating") double rating) {
        List<Movie> movieList = movieService.getMoviesByActorRating(rating);
        List<MovieDTO> moviesDTO = MovieDTO.listEntitytoListDto(movieList);

        return new ResponseEntity<>(moviesDTO, HttpStatus.OK);
    }

    @GetMapping("/filter-by-genre-name")
    public ResponseEntity<List<MovieDTO>> getMoviesByActorRating(@RequestParam("genre_name") String genre_name) {
        List<Movie> movieList = movieService.getMoviesByGenreName(genre_name);
        List<MovieDTO> moviesDTO = MovieDTO.listEntitytoListDto(movieList);

        return new ResponseEntity<>(moviesDTO, HttpStatus.OK);
    }

}
