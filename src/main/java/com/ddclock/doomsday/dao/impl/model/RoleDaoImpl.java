package com.ddclock.doomsday.dao.impl.model;


import com.ddclock.doomsday.dao.abstracts.model.RoleDao;
import com.ddclock.doomsday.dao.util.SingleResultUtil;
import com.ddclock.doomsday.models.entity.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class RoleDaoImpl extends ReadWriteDaoImpl<Role, Long> implements RoleDao {

    private final EntityManager entityManager;

    public RoleDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Role> getRoleByName(String name) {
        String hql = "FROM Role WHERE name = :name";
        TypedQuery<Role> query = (TypedQuery<Role>) entityManager.createQuery(hql).setParameter("name", name);
        return SingleResultUtil.getSingleResultOrNull(query);
    }
}
