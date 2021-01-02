package com.ddclock.doomsday.webapp.controllers;

import com.ddclock.doomsday.models.dto.DictionaryDto;
import com.ddclock.doomsday.models.dto.UserDto;
import com.ddclock.doomsday.models.dto.WordDto;
import com.ddclock.doomsday.service.abstracts.dto.DictionaryDtoService;
import com.ddclock.doomsday.service.abstracts.dto.UserDtoService;
import com.ddclock.doomsday.service.abstracts.dto.WordDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/entities")
public class EntitiesController {

    private final UserDtoService userDtoService;
    private final DictionaryDtoService dictionaryDtoService;
    private final WordDtoService wordDtoService;

    @Autowired
    public EntitiesController(UserDtoService userDtoService, DictionaryDtoService dictionaryDtoService, WordDtoService wordDtoService) {
        this.userDtoService = userDtoService;
        this.dictionaryDtoService =dictionaryDtoService;
        this.wordDtoService = wordDtoService;
    }

    @GetMapping("allUsers")
    public ResponseEntity<?> getAllUsers() {

        List<UserDto> userDtoList = userDtoService.getAllUsers();

        return userDtoList.isEmpty() ? ResponseEntity.badRequest().body("No one user found") :
                ResponseEntity.ok().body(userDtoList);

    }

    @GetMapping("allDictionary")
    public ResponseEntity<?> getAllDictionary() {

        List<DictionaryDto> dictionaryDtoList = dictionaryDtoService.getAll();

        return dictionaryDtoList.isEmpty() ? ResponseEntity.badRequest().body("No one dictionary in BD") :
                ResponseEntity.ok().body(dictionaryDtoList);
    }

    @GetMapping("allWords")
    public ResponseEntity<?> getAllWords() {

        List<WordDto> wordDtoList = wordDtoService.getAll();

        return wordDtoList.isEmpty() ? ResponseEntity.badRequest().body("No one Word in BD") :
                ResponseEntity.ok().body(wordDtoList);
    }
}
