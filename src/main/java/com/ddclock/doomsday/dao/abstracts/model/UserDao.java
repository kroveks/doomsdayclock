package com.ddclock.doomsday.dao.abstracts.model;

import com.ddclock.doomsday.models.entity.User;

import java.util.Optional;

public interface UserDao extends ReadWriteDao<User, Long> {
    Optional<User> getUserByEmail(String email);

    Optional<User> getUserByName(String name);
}
