package com.example.technokratostest.dto;

import com.example.technokratostest.models.Film;
import com.example.technokratostest.models.UserSummary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSummaryDto {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private List<Film> films;

    public static UserSummaryDto from(UserSummary userSummary) {
        return UserSummaryDto.builder()
                .id(userSummary.getId())
                .email(userSummary.getEmail())
                .firstName(userSummary.getFirstName())
                .lastName(userSummary.getLastName())
                .films(userSummary.getFilms())
                .build();
    }

    public static List<UserSummaryDto> from(List<UserSummary> userSummaries) {
        return userSummaries.stream().map(UserSummaryDto::from).collect(Collectors.toList());
    }

    public static UserSummary from(UserSummaryDto userSummaryDto) {
        return UserSummary.builder()
                .id(userSummaryDto.getId())
                .email(userSummaryDto.getEmail())
                .firstName(userSummaryDto.getFirstName())
                .lastName(userSummaryDto.getLastName())
                .films(userSummaryDto.getFilms())
                .build();
    }
}
