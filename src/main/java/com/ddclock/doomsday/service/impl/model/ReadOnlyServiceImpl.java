package com.ddclock.doomsday.service.impl.model;

import com.ddclock.doomsday.dao.abstracts.model.ReadOnlyDao;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


public abstract class ReadOnlyServiceImpl<E, K>  {

    private final ReadOnlyDao<E, K> readOnlyDao;

    protected ReadOnlyServiceImpl(ReadOnlyDao<E, K> readOnlyDao) {
        this.readOnlyDao = readOnlyDao;
    }

    @Transactional
    public List<E> getAll() {
        return readOnlyDao.getAll();
    }

    @Transactional
    public boolean existsById(K id) {
        return readOnlyDao.existsById(id);
    }

    @Transactional
    public Optional<E> getById(K id) {
        return readOnlyDao.getById(id);
    }

    @Transactional
    public List<E> getAllByIds(Iterable<K> ids) {
        return readOnlyDao.getAllByIds(ids);
    }

    @Transactional
    public boolean existsByAllIds(Collection<K> ids) {
        return readOnlyDao.existsByAllIds(ids);
    }
}
