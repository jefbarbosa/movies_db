package com.jef.movies.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "actors")
@Data
public class Actor {
    @Id
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String firstName;
    private String lastName;
    private double rating;

    @ManyToMany(mappedBy = "actors")
    @JsonIgnore
    private Set<Episode> episodes;


    @ManyToMany(mappedBy = "actors")
    @JsonIgnore
    private Set<Movie> movies;
}
