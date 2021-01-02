package com.ddclock.doomsday.service.abstracts.dto;

import com.ddclock.doomsday.models.dto.UserDto;
import com.ddclock.doomsday.models.dto.UserProfileDto;

import java.util.List;
import java.util.Optional;

public interface UserDtoService {
    Optional<UserDto> getUserDtoById(Long id);
    Optional<UserProfileDto> getUserProfileDtoById(Long id);
    List<UserDto> getAllUsers();
}
