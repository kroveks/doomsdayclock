package com.ddclock.doomsday.dao.abstracts.dto;

import com.ddclock.doomsday.models.dto.DictionaryDto;
import java.util.List;
import java.util.Optional;

public interface DictionaryDtoDao {
    List<DictionaryDto> getAll();
    List<DictionaryDto> getAllByUserId(long id);
}
