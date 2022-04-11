package com.jef.movies.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genres")
@Data
public class Genre {
    @Id
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String name;
    private int ranking;
    private int active;

    @OneToMany(mappedBy = "genre")
    private List<Serie> series = new ArrayList<>();

    @OneToMany(mappedBy = "genre")
    private List<Movie> movies = new ArrayList<>();
}
