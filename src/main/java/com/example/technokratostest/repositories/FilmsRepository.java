package com.example.technokratostest.repositories;

import com.example.technokratostest.models.Film;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmsRepository extends MongoRepository<Film, String> {
}
