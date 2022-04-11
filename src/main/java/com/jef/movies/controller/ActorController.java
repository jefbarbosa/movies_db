package com.jef.movies.controller;

import com.jef.movies.entity.Actor;
import com.jef.movies.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/prefix-first-name")
    public ResponseEntity<List<Actor>> getActorsGreaterThanRating(@RequestParam("prefixFirstName") String prefixFirstName) {
        return new ResponseEntity<>(actorService.getActorWithFirstNamePrefix(prefixFirstName), HttpStatus.OK);
    }

    @GetMapping("/{rating}")
    public ResponseEntity<List<Actor>> getActorsGreaterThanRating(@PathVariable("rating") double rating) {
        return new ResponseEntity<>(actorService.getActorsGreaterThanRating(rating), HttpStatus.OK);
    }

    @GetMapping("/actors-by-movie")
    public ResponseEntity<List<Actor>> getActorsByMovie(@RequestParam("movie") String movie) {
        return new ResponseEntity<>(actorService.getActorsByMovie(movie), HttpStatus.OK);
    }
}
