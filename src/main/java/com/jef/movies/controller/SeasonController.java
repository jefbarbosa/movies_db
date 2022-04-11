package com.jef.movies.controller;

import com.jef.movies.entity.Serie;
import com.jef.movies.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/serie")
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

    @GetMapping("/find-all-greater-than-seasons")
    public ResponseEntity<List<Serie>> seriesWithGreaterSeasons(@RequestParam("seasons_number") int seasonsNumber) {
        return new ResponseEntity<>(seasonService.seriesWithGreaterSeasons(seasonsNumber),HttpStatus.OK);
    }
}
