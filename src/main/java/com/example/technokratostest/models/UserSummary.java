package com.example.technokratostest.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class UserSummary {
    @Id
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private List<Film> films;
}
