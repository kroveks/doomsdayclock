package com.ddclock.doomsday.service.impl.dto;

import com.ddclock.doomsday.dao.abstracts.dto.UserDtoDao;
import com.ddclock.doomsday.models.dto.UserDto;
import com.ddclock.doomsday.models.dto.UserProfileDto;
import com.ddclock.doomsday.models.mappers.UserMapper;
import com.ddclock.doomsday.service.abstracts.dto.UserDtoService;
import com.ddclock.doomsday.service.abstracts.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDtoServiceImpl implements UserDtoService {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserDtoDao userDtoDao;

    @Override
    public Optional<UserDto> getUserDtoById(Long id) {
        return Optional.of(userMapper.userToUserDto(userService.getById(id).get()));
    }

    @Override
    public Optional<UserProfileDto> getUserProfileDtoById(Long id) {
        return Optional.of(userMapper.userToUserProfileDto(userService.getById(id).get()));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userDtoDao.getAllUsers();
    }

}
