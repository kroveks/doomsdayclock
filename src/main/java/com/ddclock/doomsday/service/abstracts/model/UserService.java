package com.ddclock.doomsday.service.abstracts.model;

import com.ddclock.doomsday.models.entity.User;

import java.util.Optional;

public interface UserService extends ReadWriteService<User, Long> {
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserByName(String name);
}
