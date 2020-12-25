package com.ddclock.doomsday.dao.abstracts.model;

import com.ddclock.doomsday.models.entity.Dictionary;

import java.util.Optional;

/**
 * Interface extends all methods from ReadOnlyDao and ReadWriteDao
 * Interface declare some new methods
 */
public interface DictionaryDao extends ReadWriteDao<Dictionary, Long>{

    /**
     * Use dictionary title to fing dictionary in database
     * @param title
     * @return Optional<Dictionary>
     */
    Optional<Dictionary> getDictionaryByTitle(String title);
}