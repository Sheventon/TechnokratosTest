package com.example.technokratostest.services;

import com.example.technokratostest.dto.FilmsDto;
import com.example.technokratostest.models.Film;

import java.util.List;

public interface FilmsService {
    FilmsDto save(FilmsDto filmsDto);
    List<FilmsDto> saveAll(List<Film> films);
    FilmsDto getById(String id);
    List<FilmsDto> getAll();
    void delete(String id);
    void deleteAll(List<Film> films);
    FilmsDto update(FilmsDto filmsDto);
}
