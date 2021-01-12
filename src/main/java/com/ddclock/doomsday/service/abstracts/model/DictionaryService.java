package com.ddclock.doomsday.service.abstracts.model;

import com.ddclock.doomsday.exeptions.DictionaryDoesNotExistException;
import com.ddclock.doomsday.exeptions.WordAlreadyExistInDictException;
import com.ddclock.doomsday.models.entity.Dictionary;
import com.ddclock.doomsday.models.entity.Word;

import java.util.Optional;

public interface DictionaryService extends ReadWriteService<Dictionary, Long>{

    /**
     * Use dictionary title to fing dictionary in database
     * @param title
     * @return Optional<Dictionary>
     */
    Optional<Dictionary> getDictionaryByTitle(String title);

    void addWordToDictionary(Word word, Long id) throws WordAlreadyExistInDictException, DictionaryDoesNotExistException;
}
