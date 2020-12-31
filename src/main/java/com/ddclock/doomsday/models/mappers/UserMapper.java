package com.ddclock.doomsday.models.mappers;

import com.ddclock.doomsday.models.dto.UserDto;
import com.ddclock.doomsday.models.dto.UserProfileDto;
import com.ddclock.doomsday.models.dto.UserRegistrationDto;
import com.ddclock.doomsday.models.entity.User;
import com.ddclock.doomsday.service.abstracts.model.RoleService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Autowired
    RoleService roleService;

    public abstract UserDto userToUserDto(User user);

    public abstract User userDtoToUser(UserDto userDto);

    @Mappings({
        @Mapping(target="persistDate", source = "user.persistDateTime",
                dateFormat = "dd-MM-yyyy HH:mm:ss"),
        @Mapping( target = "roleName", source = "user.role.name"),
        @Mapping( target = "isEnable", source = "user.isEnabled")})
    public abstract UserProfileDto userToUserProfileDto (User user);

    public abstract User userRegistrationDtoToUser(UserRegistrationDto userRegistrationDto);
}
