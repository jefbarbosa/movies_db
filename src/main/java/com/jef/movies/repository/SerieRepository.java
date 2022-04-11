package com.jef.movies.repository;

import com.jef.movies.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {
    List<Serie> findAllBySeasonsNumberGreaterThanEqual(int seasonsNumber);
}
