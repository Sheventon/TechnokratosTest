package com.example.technokratostest.controllers;

import com.example.technokratostest.dto.TMDBPageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FilmsController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getFilms")
    public ResponseEntity<TMDBPageDto> getFilmsFromTMbd(@RequestParam(name = "max-rating") String maxRating,
                                                        @RequestParam(name = "min-rating") String minRating,
                                                        @RequestParam(name = "page") String page,
                                                        @RequestParam(name = "query") String query) {
        String url = "https://watchlater.cloud.technokratos.com/search/film?max-rating={max-rating}&min-rating={min-rating}&page={page}&query={query}";
        TMDBPageDto pageDto = restTemplate.getForObject(url, TMDBPageDto.class, maxRating, minRating, page, query);
        return ResponseEntity.ok(pageDto);
    }
}
