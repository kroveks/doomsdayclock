package com.ddclock.doomsday.dao.abstracts.model;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


/**
 * Interface for all Dao classes
 *
 * @author Ekimovskiy Y.
 *
 * @param <E>
 * @param <K>
 */
public interface ReadOnlyDao<E, K> {

    List<E> getAll();

    boolean existsById(K id);

    Optional<E> getById(K id);

    List<E> getAllByIds(Iterable<K> ids);

    boolean existsByAllIds(Collection<K> ids);

}
