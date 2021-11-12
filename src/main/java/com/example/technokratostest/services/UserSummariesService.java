package com.example.technokratostest.services;

import com.example.technokratostest.dto.FilmsDto;
import com.example.technokratostest.dto.UserSummaryDto;

import java.util.List;

public interface UserSummariesService {
    UserSummaryDto save(UserSummaryDto userSummaryDto);
    List<UserSummaryDto> getAll();
    UserSummaryDto getById(String id);
    void remove(String id);
    UserSummaryDto update(UserSummaryDto userSummaryDto);

    UserSummaryDto addFilmsToUserSummary(List<FilmsDto> results, UserSummaryDto userSummaryDto);
}
