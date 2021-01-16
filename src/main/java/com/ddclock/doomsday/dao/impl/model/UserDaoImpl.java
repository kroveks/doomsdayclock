package com.ddclock.doomsday.dao.impl.model;

import com.ddclock.doomsday.dao.abstracts.model.UserDao;
import com.ddclock.doomsday.dao.util.SingleResultUtil;
import com.ddclock.doomsday.models.entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class UserDaoImpl extends ReadWriteDaoImpl<User, Long> implements UserDao {

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        String hql = "FROM User WHERE email = :email";
        TypedQuery<User> query = (TypedQuery<User>) getEntityManager().createQuery(hql).setParameter("email", email);
        return SingleResultUtil.getSingleResultOrNull(query);
    }

    @Override
    public Optional<User> getUserByName(String name) {
        return getEntityManager().unwrap(Session.class)
                .createQuery("SELECT u FROM User as u WHERE lower(u.fullName) LIKE lower('%" + name + "%') ")
                .getResultList().stream().findFirst();
    }

    public void deleteWithDictionaryById(Long id) {
        String hql1 = "delete from Dictionary as d WHERE d.user.id = :id";
        entityManager.createQuery(hql1).setParameter("id", id).executeUpdate();

        String hql = "DELETE User WHERE id = :id";
        entityManager.createQuery(hql).setParameter("id", id).executeUpdate();
    }

    @Override
    public boolean existByEmail(String email) {
        long count = (long) entityManager.createQuery("SELECT COUNT(e) FROM User e WHERE e.email =: email").setParameter("email", email).getSingleResult();
        return count > 0;
    }
}
