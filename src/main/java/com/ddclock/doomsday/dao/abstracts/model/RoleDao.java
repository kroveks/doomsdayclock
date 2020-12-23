package com.ddclock.doomsday.dao.abstracts.model;

import com.ddclock.doomsday.models.entity.Role;

import java.util.Optional;

/**
 * Interface extends all methods from ReadOnlyDao and ReadWriteDao
 * Interface declare some new methods
 */
public interface RoleDao extends ReadWriteDao<Role, Long> {
    /**
     * Uses role name to find role in dataBase.
     * @param name
     * @return Optional<Role>
     */
    Optional<Role> getRoleByName(String name);
}

