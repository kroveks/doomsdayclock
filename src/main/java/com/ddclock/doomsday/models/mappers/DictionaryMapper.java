package com.ddclock.doomsday.models.mappers;


import com.ddclock.doomsday.models.dto.DictionaryCreateDto;
import com.ddclock.doomsday.models.dto.DictionaryDto;
import com.ddclock.doomsday.models.entity.Dictionary;
import com.ddclock.doomsday.models.entity.User;
import com.ddclock.doomsday.models.entity.Word;
import com.ddclock.doomsday.service.abstracts.model.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Mapper(componentModel = "spring")
public abstract class DictionaryMapper {

    @Autowired
    UserService userService;


    @Mapping(target = "user", source = "userId",qualifiedByName = "mapUser")
    public abstract Dictionary DictionaryCreteDtoToDictionary(DictionaryCreateDto dictionaryCreateDto);

    @Mapping(target = "wordCount", source = "words", qualifiedByName ="wordCount")
    public abstract DictionaryDto DictionaryDtoFromDictionary(Dictionary dictionary);

    @Named("mapUser")
    public User mapUser(Long id) {
        return userService.getById(id).get();
    }

    @Named("wordCount")
    public int wordCount(List<Word> words) {
        return words.size();
    }


}
