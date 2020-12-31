package com.ddclock.doomsday.models.mappers;

import com.ddclock.doomsday.models.dto.UserDto;
import com.ddclock.doomsday.models.dto.UserProfileDto;
import com.ddclock.doomsday.models.dto.UserRegistrationDto;
import com.ddclock.doomsday.models.entity.User;

public abstract class UserMapper {
    public abstract UserDto userToUserDto(User user);
    public abstract User userDtoToUser(UserDto userDto);
    public abstract UserProfileDto userToUserProfileDto (User user);
    public abstract User userRegistrationDtoToUser(UserRegistrationDto userRegistrationDto);
}
