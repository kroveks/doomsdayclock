package com.ddclock.doomsday.webapp.controllers.rest;


import com.ddclock.doomsday.models.dto.DictionaryDto;
import com.ddclock.doomsday.service.abstracts.dto.DictionaryDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Validated
@RequestMapping("/api/dictionary")
public class DictionaryController {



}
