package com.jef.movies.repository;

import com.jef.movies.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    List<Actor> findActorsByRatingGreaterThanEqual(double rating);

    /* Below are three equivalent methods */
    List<Actor> findByMovies_title (String movie);
    List<Actor> findAllActorsByMoviesTitle(String movie);
    //select a.* from actors a inner join actor_movie am on a.id=am.actor_id inner join movies m on m.id=am.movie_id where m.title='titanic';
    @Query("from Actor a inner join a.movies m where m.title=:movie")
    List<Actor> findAllActors_UsingMovieTitle(String movie);


}
