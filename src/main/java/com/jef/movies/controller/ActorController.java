package com.jef.movies.controller;

import com.jef.movies.entity.Actor;
import com.jef.movies.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/{rating}")
    public ResponseEntity<List<Actor>> getActorsGreaterThanRating(@PathVariable("rating") double rating) {
        return new ResponseEntity<>(actorService.getActorsGreaterThanRating(rating), HttpStatus.OK);
    }
}
