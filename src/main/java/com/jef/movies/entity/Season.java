package com.jef.movies.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "seasons")
@Data
public class Season {
    @Id
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String title;
    private int number;
    private LocalDateTime releaseDate;
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "serie_id", referencedColumnName = "id")
    private Serie serie;

    @OneToMany(mappedBy = "season")
    private List<Episode> episodes = new ArrayList<>();
}
