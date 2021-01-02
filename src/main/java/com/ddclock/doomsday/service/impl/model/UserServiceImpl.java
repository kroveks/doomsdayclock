package com.ddclock.doomsday.service.impl.model;


import com.ddclock.doomsday.dao.abstracts.model.UserDao;
import com.ddclock.doomsday.models.entity.User;
import com.ddclock.doomsday.service.abstracts.model.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class UserServiceImpl extends ReadWriteServiceImpl<User, Long> implements UserService {

    private final UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public Optional<User> getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public void persist(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        super.persist(user);
    }

    @Override
    @Transactional
    public void deleteWithDictionaryById(Long id){
        userDao.deleteWithDictionaryById(id);
    }
}
