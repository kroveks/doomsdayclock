package com.ddclock.doomsday.service.impl.model;

import com.ddclock.doomsday.dao.abstracts.model.WordDao;
import com.ddclock.doomsday.models.entity.Word;
import com.ddclock.doomsday.service.abstracts.model.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl extends ReadWriteServiceImpl<Word, Long> implements WordService {

    private final WordDao wordDao;

    @Autowired
    public WordServiceImpl(WordDao wordDao) {
        super(wordDao);
        this.wordDao = wordDao;
    }
}
