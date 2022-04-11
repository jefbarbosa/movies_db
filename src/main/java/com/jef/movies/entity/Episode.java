package com.jef.movies.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "episodes")
@Data
public class Episode {
    @Id
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String title;
    private int number;
    private LocalDateTime releaseDate;
    private double rating;

    @ManyToOne
    @JoinColumn(name = "season_id", referencedColumnName = "id")
    private Season season;

    @ManyToMany
    @JoinTable(name = "actor_episode",
            joinColumns = {@JoinColumn(name = "episode_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")})
    private Set<Actor> actors;
}
