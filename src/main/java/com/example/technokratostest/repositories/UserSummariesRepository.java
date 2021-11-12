package com.example.technokratostest.repositories;

import com.example.technokratostest.models.UserSummary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserSummariesRepository extends MongoRepository<UserSummary, String> {
}
