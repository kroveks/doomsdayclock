package com.ddclock.doomsday.service.impl.dto;

import com.ddclock.doomsday.dao.abstracts.dto.DictionaryDtoDao;
import com.ddclock.doomsday.models.dto.DictionaryDto;
import com.ddclock.doomsday.service.abstracts.dto.DictionaryDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryDtoServiceImpl implements DictionaryDtoService {

    @Autowired
    DictionaryDtoDao dictionaryDtoDao;

    @Override
    public List<DictionaryDto> getAll() {
        return dictionaryDtoDao.getAll();
    }
}
