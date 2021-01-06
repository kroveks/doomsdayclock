package com.ddclock.doomsday.service.abstracts.model;

import com.ddclock.doomsday.exception.WordAlreadyExistInDictException;
import com.ddclock.doomsday.models.entity.Dictionary;
import com.ddclock.doomsday.models.entity.Word;

import java.util.List;
import java.util.Optional;

public interface DictionaryService extends ReadWriteService<Dictionary, Long>{

    /**
     * Use dictionary title to fing dictionary in database
     * @param title
     * @return Optional<Dictionary>
     */
    Optional<Dictionary> getDictionaryByTitle(String title);

    List<Word> addWordToDictionary(Word word, Long id) throws WordAlreadyExistInDictException;
}
