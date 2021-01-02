package com.ddclock.doomsday.dao.abstracts.dto;

import com.ddclock.doomsday.models.dto.UserDto;

import java.util.List;

public interface UserDtoDao {
    List<UserDto> getAllUsers();
}
