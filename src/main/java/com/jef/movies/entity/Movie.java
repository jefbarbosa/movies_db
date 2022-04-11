package com.jef.movies.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "movies")
@Data
public class Movie {
    @Id
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String title;
    private double rating;
    private int awards;
    private LocalDateTime releaseDate;
    private int length;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "actor_movie",
            joinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id", referencedColumnName = "id")})
    private Set<Actor> actors;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;

}
