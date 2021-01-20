package com.ddclock.doomsday.dao.abstracts.dto;

import com.ddclock.doomsday.models.dto.DictionaryDto;
import java.util.List;

public interface DictionaryDtoDao {
    List<DictionaryDto> getAll();
    List<DictionaryDto> getAllByUserId(long id);
}
