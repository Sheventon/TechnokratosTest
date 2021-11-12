package com.example.technokratostest.services;

import com.example.technokratostest.dto.FilmsDto;
import com.example.technokratostest.dto.UserSummaryDto;
import com.example.technokratostest.models.Film;
import com.example.technokratostest.models.UserSummary;
import com.example.technokratostest.repositories.UserSummariesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSummariesServiceImpl implements UserSummariesService {

    private final UserSummariesRepository userSummariesRepository;
    private final FilmsService filmsService;

    public UserSummariesServiceImpl(UserSummariesRepository userSummariesRepository, FilmsService filmsService) {
        this.userSummariesRepository = userSummariesRepository;
        this.filmsService = filmsService;
    }

    @Override
    public UserSummaryDto save(UserSummaryDto userSummary) {
        filmsService.saveAll(userSummary.getFilms());
        UserSummary film = UserSummaryDto.from(userSummary);
        return UserSummaryDto.from(userSummariesRepository.save(film));
    }

    @Override
    public List<UserSummaryDto> getAll() {
        return UserSummaryDto.from(userSummariesRepository.findAll());
    }

    @Override
    public UserSummaryDto getById(String id) {
        return UserSummaryDto.from(userSummariesRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Summary with id " + id + "does not exist.")));
    }

    @Override
    public void remove(String id) {
        UserSummary userSummary = userSummariesRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Summary with id " + id + "does not exist."));
        filmsService.deleteAll(userSummary.getFilms());
        userSummariesRepository.deleteById(id);
    }

    @Override
    public UserSummaryDto update(UserSummaryDto userSummaryDto) {
        UserSummary newUserSummary = UserSummaryDto.from(userSummaryDto);
        UserSummary oldUserSummary = userSummariesRepository.findById(userSummaryDto.getId())
                .orElseThrow(() -> new IllegalStateException("Summary with id " + userSummaryDto.getId() + "does not exist."));
        List<Film> films = oldUserSummary.getFilms();
        films.addAll(newUserSummary.getFilms());
        newUserSummary.setFilms(films);
        for (Film film : newUserSummary.getFilms()) {
            filmsService.save(FilmsDto.from(film));
        }
        return UserSummaryDto.from(userSummariesRepository.save(newUserSummary));
    }

    @Override
    public UserSummaryDto addFilmsToUserSummary(List<FilmsDto> results, UserSummaryDto userSummaryDto) {
        UserSummary userSummary = UserSummaryDto.from(userSummaryDto);
        for (FilmsDto filmsDto : results) {
            Film film = FilmsDto.from(filmsService.save(filmsDto));
            userSummary.getFilms().add(film);
        }
        return UserSummaryDto.from(userSummary);
    }
}
