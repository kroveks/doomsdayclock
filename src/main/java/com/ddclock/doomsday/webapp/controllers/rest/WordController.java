package com.ddclock.doomsday.webapp.controllers.rest;

import com.ddclock.doomsday.exeptions.DictionaryDoesNotExistException;
import com.ddclock.doomsday.exeptions.WordAlreadyExistInDictException;
import com.ddclock.doomsday.models.dto.WordCreateDto;
import com.ddclock.doomsday.models.entity.Word;
import com.ddclock.doomsday.models.mappers.WordMapper;
import com.ddclock.doomsday.service.abstracts.model.DictionaryService;
import com.ddclock.doomsday.service.abstracts.model.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@Validated
@RequestMapping("/api/word/")
public class WordController {

    @Autowired
    private WordService wordService;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private WordMapper wordMapper;

    @PostMapping("add")
    public ResponseEntity<?> addWordIntoDictionary(@Valid @RequestBody WordCreateDto wordCreateDto) {

        Word word = wordMapper.wordCreateDtoToWord(wordCreateDto);
        word.setPersistDateTime(LocalDateTime.now());

        wordService.persist(word);

        try {
            dictionaryService.addWordToDictionary(word,wordCreateDto.getDictionaryId());
        } catch (WordAlreadyExistInDictException e) {
            e.printStackTrace();
        } catch (DictionaryDoesNotExistException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(wordMapper.wordToWordDto(word));
    }
}
