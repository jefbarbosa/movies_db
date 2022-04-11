package com.jef.movies.repository;

import com.jef.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByActorsRatingGreaterThanEqual(double rating);

    @Query("from Movie m inner join m.actors a where a.rating>=:rating")
    List<Movie> findAllWithActorsRatingGreaterThanEqual(double rating);

    List<Movie> findAllByGenreName(String genreName);
}
