package com.ddclock.doomsday.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryWordsDto {
    private Long id;
    private String title;
    private String description;
    private int wordCount;
    private List<WordDto> wordDtoList;
}
