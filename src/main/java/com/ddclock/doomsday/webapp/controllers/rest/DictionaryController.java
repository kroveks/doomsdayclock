package com.ddclock.doomsday.webapp.controllers.rest;

import com.ddclock.doomsday.models.dto.DictionaryCreateDto;
import com.ddclock.doomsday.models.dto.DictionaryDto;
import com.ddclock.doomsday.models.entity.Dictionary;
import com.ddclock.doomsday.models.mappers.DictionaryMapper;
import com.ddclock.doomsday.service.abstracts.dto.DictionaryDtoService;
import com.ddclock.doomsday.service.abstracts.model.DictionaryService;
import com.ddclock.doomsday.service.abstracts.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

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

    @Autowired
    DictionaryDtoService dictionaryDtoService;

    @PostMapping("/add")
    public ResponseEntity<?> addDictionary(@Valid @RequestBody DictionaryCreateDto dictionaryCreateDto) {
        if(!userService.existsById(dictionaryCreateDto.getUserId())) {
                        return ResponseEntity.badRequest().body("questionCreateDto.userId dont`t exist");
        }
        Dictionary dictionary = dictionaryMapper.DictionaryCreteDtoToDictionary(dictionaryCreateDto);

        dictionaryService.persist(dictionary);

        return ResponseEntity.ok(dictionaryMapper.DictionaryDtoFromDictionary(dictionary));
    }

    @GetMapping("{id}")
    public ResponseEntity getDictionaryById(@PathVariable Long id) {

        Optional<DictionaryDto> dictionaryDto = dictionaryDtoService.getDictionaryById(id);

        return dictionaryDto.isPresent() ? ResponseEntity.ok().body(dictionaryDto.get()) :
                ResponseEntity.badRequest().body("Dictionary with " + id + " not found");
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteDictionaryById(@PathVariable Long id) {
        Optional<Dictionary> dictionaryObj = dictionaryService.getById(id);

        if(dictionaryObj.isPresent()) {
            Dictionary dictionary = dictionaryObj.get();
            try{
                dictionaryService.deleteById(dictionary.getId());
                return ResponseEntity.ok().body("Dictionary with " + dictionary.getId() + " has been deleted");
            }catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.badRequest().body("The dictionary has already been deleted");
            }
        }
        return ResponseEntity.badRequest().body("Something went wrong when deleting a dictionary");
    }

    @GetMapping("/title/{title}")
    public ResponseEntity getDictionaryByTitle(@PathVariable String title) {
        Optional<DictionaryDto> dictionaryDto = dictionaryDtoService.getDictionaryByTitle(title);

        return dictionaryDto.isPresent() ? ResponseEntity.ok().body(dictionaryDto.get()) :
                ResponseEntity.badRequest().body("Dictionary with title - " + title + " not found");
    }

}
