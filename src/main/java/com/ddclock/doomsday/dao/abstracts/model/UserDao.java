package com.ddclock.doomsday.dao.abstracts.model;

import com.ddclock.doomsday.models.entity.User;

import java.util.Optional;

/**
 * Interface extends all methods from ReadOnlyDao and ReadWriteDao
 * Interface declare some new methods
 */
public interface UserDao extends ReadWriteDao<User, Long> {
    /**
     * method try find user by email in database adn return it
     * @param email
     * @return
     */
    Optional<User> getUserByEmail(String email);

    /**
     * method try find user by name in database adn return it
     * @param name
     * @return
     */
    Optional<User> getUserByName(String name);

    void deleteWithDictionaryById(Long id);

    boolean existByEmail(String email);
}
