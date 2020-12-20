package com.ddclock.doomsday.dao.impl.model;

import com.ddclock.doomsday.dao.abstracts.model.DictionaryDao;
import com.ddclock.doomsday.dao.util.SingleResultUtil;
import com.ddclock.doomsday.models.entity.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class DictionaryDaoImpl extends ReadWriteDaoImpl<Dictionary, Long> implements DictionaryDao {

    private final EntityManager entityManager;

    @Autowired
    public DictionaryDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Dictionary> getDictionaryByTitle(String title) {
        String hql = "FROM Dictionary WHERE title = :title";
        TypedQuery<Dictionary> query = (TypedQuery<Dictionary>) entityManager.createQuery(hql).setParameter("title", title);
        return SingleResultUtil.getSingleResultOrNull(query);
    }
}
