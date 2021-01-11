package com.ddclock.doomsday.webapp.controllers.rest;

import com.ddclock.doomsday.models.dto.DictionaryCreateDto;
import com.ddclock.doomsday.models.entity.Dictionary;
import com.ddclock.doomsday.models.mappers.DictionaryMapper;
import com.ddclock.doomsday.service.abstracts.model.DictionaryService;
import com.ddclock.doomsday.service.abstracts.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/api/dictionary")
public class DictionaryController {

    @Autowired
    UserService userService;

    @Autowired
    DictionaryMapper dictionaryMapper;

    @Autowired
    DictionaryService dictionaryService;

    @PostMapping("/add")
    public ResponseEntity<?> addDictionary(@Valid @RequestBody DictionaryCreateDto dictionaryCreateDto) {
        if(!userService.existsById(dictionaryCreateDto.getUserId())) {
                        return ResponseEntity.badRequest().body("questionCreateDto.userId dont`t exist");
        }
        Dictionary dictionary = dictionaryMapper.DictionaryCreteDtoToDictionary(dictionaryCreateDto);

        dictionaryService.persist(dictionary);

        return ResponseEntity.ok(dictionaryMapper.DictionaryDtoFromDictionary(dictionary));
    }

}
