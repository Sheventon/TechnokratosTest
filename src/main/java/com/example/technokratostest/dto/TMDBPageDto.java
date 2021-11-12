package com.example.technokratostest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TMDBPageDto {
    private Integer page;
    private List<FilmsDto> results;
    private Integer resultsOnPage;
    private Integer totalPages;
    private Integer totalResults;
}
