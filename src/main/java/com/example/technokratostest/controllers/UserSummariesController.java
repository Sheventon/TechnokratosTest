package com.example.technokratostest.controllers;

import com.example.technokratostest.dto.TMDBPageDto;
import com.example.technokratostest.dto.UserSummaryDto;
import com.example.technokratostest.services.UserSummariesService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserSummariesController {

    private final UserSummariesService userSummariesService;

    public UserSummariesController(UserSummariesService userSummariesService) {
        this.userSummariesService = userSummariesService;
    }

    @PostMapping("/summary/add")
    public ResponseEntity<UserSummaryDto> addSummary(@RequestBody UserSummaryDto userSummaryDto) {
        return ResponseEntity.ok(userSummariesService.save(userSummaryDto));
    }

    @GetMapping("/summary/get/all")
    public ResponseEntity<List<UserSummaryDto>> getAllSummaries() {
        return ResponseEntity.ok(userSummariesService.getAll());
    }

    @GetMapping("/summary/get/{id}")
    public ResponseEntity<UserSummaryDto> getSummaryById(@PathVariable String id) {
        return ResponseEntity.ok(userSummariesService.getById(id));
    }

    @PostMapping("/summary/remove/{id}")
    public ResponseEntity<?> removeSummary(@PathVariable String id) {
        userSummariesService.remove(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/summary/update")
    public ResponseEntity<UserSummaryDto> updateSummary(@RequestBody UserSummaryDto userSummaryDto) {
        return ResponseEntity.ok(userSummariesService.update(userSummaryDto));
    }

    @PostMapping("/summary/addFilms")
    public ResponseEntity<UserSummaryDto> addFilmsToUser(@RequestBody UserSummaryDto userSummaryDto,
                                                         @RequestParam(name = "max-rating") String maxRating,
                                                         @RequestParam(name = "min-rating") String minRating,
                                                         @RequestParam(name = "page") String page,
                                                         @RequestParam(name = "query") String query) {
        String url = "http://localhost:8080/getFilms?max-rating={max-rating}&min-rating={min-rating}&page={page}&query={query}";
        RestTemplate restTemplate = new RestTemplate();
        TMDBPageDto tmdbPageDto = restTemplate.getForObject(url, TMDBPageDto.class, maxRating, minRating, page, query);
        if (tmdbPageDto != null) {
            return ResponseEntity.ok(userSummariesService.addFilmsToUserSummary(tmdbPageDto.getResults(), userSummaryDto));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
