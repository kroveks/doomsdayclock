package com.ddclock.doomsday.service.impl.model;

import com.ddclock.doomsday.dao.abstracts.model.DictionaryDao;
import com.ddclock.doomsday.exeptions.DictionaryDoesNotExistException;
import com.ddclock.doomsday.exeptions.WordAlreadyExistInDictException;
import com.ddclock.doomsday.models.entity.Dictionary;
import com.ddclock.doomsday.models.entity.Word;
import com.ddclock.doomsday.service.abstracts.model.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DictionaryServiceImpl extends ReadWriteServiceImpl<Dictionary, Long> implements DictionaryService {

    private final DictionaryDao dictionaryDao;

    @Autowired
    public DictionaryServiceImpl(DictionaryDao dictionaryDao) {
        super(dictionaryDao);
        this.dictionaryDao = dictionaryDao;
    }

    @Override
    public Optional<Dictionary> getDictionaryByTitle(String title) {

        return dictionaryDao.getDictionaryByTitle(title);
    }


    /**
     * Method add new word to specific dictionary
     * Throw and catch NULLPointerException if the word list is empty, be careful and check the console for stack trace
     * @param word
     * @param id
     * @return Optional(dictionary) with new word in wordsList, or exceptions, if word was already exist or dictionary not found
     */
    @Override
    public void addWordToDictionary(Word word, Long id) throws WordAlreadyExistInDictException, DictionaryDoesNotExistException {

        dictionaryDao.addWordToDictionary(word, id);
    }
}
