package com.ddclock.doomsday.dao.abstracts.dto;

import com.ddclock.doomsday.models.dto.WordDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordDtoDao {
    List<WordDto> getAll();
}
