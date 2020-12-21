package com.ddclock.doomsday.dao.impl.model;

import com.ddclock.doomsday.dao.abstracts.model.WordDao;
import com.ddclock.doomsday.models.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class WordDaoImpl extends ReadWriteDaoImpl<Word, Long> implements WordDao {

    private final EntityManager entityManager;

    @Autowired
    public WordDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
