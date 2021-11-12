package com.example.technokratostest.services;

import com.example.technokratostest.dto.FilmsDto;
import com.example.technokratostest.models.Film;
import com.example.technokratostest.repositories.FilmsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmsServiceImpl implements FilmsService {

    private final FilmsRepository filmsRepository;

    public FilmsServiceImpl(FilmsRepository filmsRepository) {
        this.filmsRepository = filmsRepository;
    }

    @Override
    public FilmsDto save(FilmsDto filmsDto) {
        Film film = FilmsDto.from(filmsDto);
        return FilmsDto.from(filmsRepository.save(film));
    }

    @Override
    public List<FilmsDto> saveAll(List<Film> films) {
        return FilmsDto.from(filmsRepository.saveAll(films));
    }

    @Override
    public FilmsDto getById(String id) {
        return FilmsDto.from(filmsRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Summary with id " + id + "does not exist.")));
    }

    @Override
    public List<FilmsDto> getAll() {
        return FilmsDto.from(filmsRepository.findAll());
    }

    @Override
    public void delete(String id) {
        filmsRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Film> films) {
        filmsRepository.deleteAll(films);
    }

    @Override
    public FilmsDto update(FilmsDto filmsDto) {
        Film film = FilmsDto.from(filmsDto);
        return FilmsDto.from(filmsRepository.save(film));
    }
}
