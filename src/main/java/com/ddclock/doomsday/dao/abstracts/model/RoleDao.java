package com.ddclock.doomsday.dao.abstracts.model;

import com.ddclock.doomsday.models.entity.Role;

import java.util.Optional;

public interface RoleDao extends ReadWriteDao<Role, String> {
    Optional<Role> getRoleByName(String name);
}

