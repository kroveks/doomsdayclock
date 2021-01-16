package com.ddclock.doomsday.service.impl.dto;

import com.ddclock.doomsday.dao.abstracts.dto.DictionaryDtoDao;
import com.ddclock.doomsday.dao.abstracts.model.DictionaryDao;
import com.ddclock.doomsday.models.dto.DictionaryDto;
import com.ddclock.doomsday.models.mappers.DictionaryMapper;
import com.ddclock.doomsday.service.abstracts.dto.DictionaryDtoService;
import com.ddclock.doomsday.service.abstracts.model.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DictionaryDtoServiceImpl implements DictionaryDtoService {

    @Autowired
    DictionaryDtoDao dictionaryDtoDao;

    @Autowired
    DictionaryService dictionaryService;

    @Autowired
    DictionaryMapper dictionaryMapper;


    @Override
    public List<DictionaryDto> getAll() {
        return dictionaryDtoDao.getAll();
    }

    @Override
    public Optional<DictionaryDto> getDictionaryById(Long id) {
        return Optional.of(dictionaryMapper.DictionaryDtoFromDictionary(dictionaryService.getById(id).get()));
    }

    @Override
    public Optional<DictionaryDto> getDictionaryByTitle(String title) {
        return Optional.of(dictionaryMapper.DictionaryDtoFromDictionary(dictionaryService.getDictionaryByTitle(title).get()));
    }

    @Override
    public List<DictionaryDto> getAllByUserId(long id) {
        return dictionaryDtoDao.getAllByUserId(id);
    }
}
