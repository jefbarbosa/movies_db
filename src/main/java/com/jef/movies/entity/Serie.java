package com.jef.movies.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "series")
@Data
public class Serie {
    @Id
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String title;
    private LocalDateTime releaseDate;
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    @JsonIgnore
    private Genre genre;

    @OneToMany(mappedBy = "serie")
    @JsonIgnore
    private List<Season> seasons = new ArrayList<>();
}
