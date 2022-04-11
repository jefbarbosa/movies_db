package com.jef.movies.dto;

import com.jef.movies.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDateTime releaseDate;
    private Integer length;

    public static MovieDTO entityToDto(Movie movie) {
        return new MovieDTO(movie.getCreatedAt(), movie.getUpdatedAt(), movie.getTitle(), movie.getRating(),
                movie.getAwards(), movie.getReleaseDate(), movie.getLength());
    }

    public static List<MovieDTO> listEntitytoListDto(List<Movie> movieList) {
        return new ArrayList<>(movieList.stream().map(MovieDTO::entityToDto).collect(Collectors.toList()));
    }


}
