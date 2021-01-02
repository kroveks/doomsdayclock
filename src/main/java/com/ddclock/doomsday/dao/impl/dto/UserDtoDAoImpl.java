package com.ddclock.doomsday.dao.impl.dto;

import com.ddclock.doomsday.dao.abstracts.dto.UserDtoDao;
import com.ddclock.doomsday.models.dto.UserDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDtoDAoImpl implements UserDtoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserDto> getAllUsers() {
            return entityManager.createQuery("SELECT new com.ddclock.doomsday.models.dto.UserDto(u.id,u.email, u.email) from User as u").getResultList();
    }
}
