package com.ddclock.doomsday.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WordCreateDto implements Serializable {
    @NotNull(message = "Значение value отсутствует")
    @NotBlank(message = "Значение value не должно быть пустым")
    private String value;

    @NotNull(message = "Значение translationValue отсутствует")
    private String translationValue;

    @NotNull(message = "Значение exampleSentence отсутствует")
    private String exampleSentence;

    @NotNull(message = "Значение userId должно быть заполнено")
    private Long userId;

    @NotNull(message = "Значение dictionaryId должно быть заполнено")
    private Long dictionaryId;
}
