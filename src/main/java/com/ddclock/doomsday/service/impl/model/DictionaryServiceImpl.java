package com.ddclock.doomsday.service.impl.model;

import com.ddclock.doomsday.dao.abstracts.model.DictionaryDao;
import com.ddclock.doomsday.models.entity.Dictionary;
import com.ddclock.doomsday.models.entity.Word;
import com.ddclock.doomsday.service.abstracts.model.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
     * Method that add new word to specific dictionary
     * @param word
     * @param id
     * @return dictionary with new word, or exception, if word was already exist
     */
    @Override
    public List<Word> addWordToDictionary(Word word, Long id) {

        return dictionaryDao.addWordToDictionary(word, id);
    }
}
