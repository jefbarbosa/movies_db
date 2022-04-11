package com.jef.movies.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Double rating;
    private Integer awards;
    private LocalDateTime releaseDate;
    private Integer length;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "actor_movie",
            joinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id", referencedColumnName = "id")})
//    @JsonIgnore
    private Set<Actor> actors;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
//    @JsonIgnore
    private Genre genre;

}
