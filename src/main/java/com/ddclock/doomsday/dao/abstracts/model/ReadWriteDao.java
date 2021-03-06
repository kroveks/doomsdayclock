package com.ddclock.doomsday.dao.abstracts.model;

import java.util.Collection;

/**
 * Interface interface expanding functionality of ReadOnlyDao
 *
 * @author Ekimovskiy Y.
 *
 * @param <E>
 * @param <K>
 */

public interface ReadWriteDao<E, K> extends ReadOnlyDao<E, K> {
    void persist(E e);

    void update(E e);

    void delete(E e);

    void persistAll(E... entities);

    void persistAll(Collection<E> entities);

    void deleteAll(Collection<E> entities);

    void updateAll(Iterable<? extends E> entities);

    void deleteById(K id);
}
