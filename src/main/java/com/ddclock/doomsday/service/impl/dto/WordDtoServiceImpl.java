package com.ddclock.doomsday.service.impl.dto;

import com.ddclock.doomsday.dao.abstracts.dto.WordDtoDao;
import com.ddclock.doomsday.models.dto.WordDto;
import com.ddclock.doomsday.service.abstracts.dto.WordDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordDtoServiceImpl implements WordDtoService {

    @Autowired
    WordDtoDao wordDtoDao;

    @Override
    public List<WordDto> getAll() {
        return wordDtoDao.getAll();
    }
}
