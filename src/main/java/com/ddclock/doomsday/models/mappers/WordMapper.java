package com.ddclock.doomsday.models.mappers;

import com.ddclock.doomsday.models.dto.WordCreateDto;
import com.ddclock.doomsday.models.dto.WordDto;
import com.ddclock.doomsday.models.entity.Word;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class WordMapper {
    public abstract Word wordDtoToWord(WordDto wordDto);

    @Mapping(target="persistDate", source = "word.persistDateTime",
            dateFormat = "dd-MM-yyyy HH:mm:ss")
    public abstract WordDto wordToWordDto(Word word);

     public abstract Word wordCreateDtoToWord(WordCreateDto wordCreateDto);
}
