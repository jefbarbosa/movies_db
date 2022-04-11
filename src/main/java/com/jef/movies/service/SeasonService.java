package com.jef.movies.service;

import com.jef.movies.entity.Serie;
import com.jef.movies.repository.SerieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeasonService {

    private SerieRepository serieRepository;

    public List<Serie> seriesWithGreaterSeasons(int seasonsNumber) {
        return serieRepository.findAllBySeasonsNumberGreaterThanEqual(seasonsNumber);
    }
}
