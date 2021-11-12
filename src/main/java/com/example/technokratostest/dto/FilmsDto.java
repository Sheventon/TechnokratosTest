package com.example.technokratostest.dto;

import com.example.technokratostest.models.Film;
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
public class FilmsDto {
    private String id;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private Double popularity;
    private String posterPath;
    private String releaseDate;
    private String title;
    private Boolean video;
    private Double voteAverage;
    private Integer voteCount;
    private Boolean adult;
    private String backdropPath;
    private List<Integer> genreIds;

    public static FilmsDto from(Film summary) {
        return FilmsDto.builder()
                .id(summary.getId())
                .originalLanguage(summary.getOriginalLanguage())
                .originalTitle(summary.getOriginalTitle())
                .overview(summary.getOverview())
                .popularity(summary.getPopularity())
                .posterPath(summary.getPosterPath())
                .releaseDate(summary.getReleaseDate())
                .title(summary.getTitle())
                .video(summary.getVideo())
                .voteAverage(summary.getVoteAverage())
                .voteCount(summary.getVoteCount())
                .adult(summary.getAdult())
                .backdropPath(summary.getBackdropPath())
                .genreIds(summary.getGenreIds())
                .build();
    }

    public static List<FilmsDto> from(List<Film> summaries) {
        return summaries.stream().map(FilmsDto::from).collect(Collectors.toList());
    }

    public static Film from(FilmsDto FilmsDto) {
        return Film.builder()
                .id(FilmsDto.getId())
                .originalLanguage(FilmsDto.getOriginalLanguage())
                .originalTitle(FilmsDto.getOriginalTitle())
                .overview(FilmsDto.getOverview())
                .popularity(FilmsDto.getPopularity())
                .posterPath(FilmsDto.getPosterPath())
                .releaseDate(FilmsDto.getReleaseDate())
                .title(FilmsDto.getTitle())
                .video(FilmsDto.getVideo())
                .voteAverage(FilmsDto.getVoteAverage())
                .voteCount(FilmsDto.getVoteCount())
                .adult(FilmsDto.getAdult())
                .backdropPath(FilmsDto.getBackdropPath())
                .genreIds(FilmsDto.getGenreIds())
                .build();
    }
}
