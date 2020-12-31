package com.ddclock.doomsday.models.mappers;

import com.ddclock.doomsday.models.dto.WordCreateDto;
import com.ddclock.doomsday.models.dto.WordDto;
import com.ddclock.doomsday.models.entity.Word;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class WordMapper {
    public abstract Word wordDtoToWord(WordDto wordDto);
    public abstract WordDto wordToWordDto(Word word);


    //Hard to realise because of list<Dictionary> in Word
    public Word wordCreateDtoToWord(WordCreateDto wordCreateDto){return null;}
}
