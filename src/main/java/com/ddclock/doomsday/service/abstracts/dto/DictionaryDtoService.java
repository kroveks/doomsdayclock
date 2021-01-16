package com.ddclock.doomsday.service.abstracts.dto;

import com.ddclock.doomsday.models.dto.DictionaryDto;

import java.util.List;
import java.util.Optional;


public interface DictionaryDtoService {
    List<DictionaryDto> getAll();
    Optional<DictionaryDto> getDictionaryById(Long id);
    Optional<DictionaryDto> getDictionaryByTitle(String title);
    List<DictionaryDto> getAllByUserId(long id);
}
