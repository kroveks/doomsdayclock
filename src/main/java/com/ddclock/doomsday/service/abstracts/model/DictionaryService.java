package com.ddclock.doomsday.service.abstracts.model;

import com.ddclock.doomsday.models.entity.Dictionary;
import com.ddclock.doomsday.models.entity.User;

import java.util.Optional;

public interface DictionaryService extends ReadWriteService<Dictionary, Long>{

    /**
     * Use dictionary title to fing dictionary in database
     * @param title
     * @return Optional<Dictionary>
     */
    Optional<Dictionary> getDictionaryByTitle(String title);
}
