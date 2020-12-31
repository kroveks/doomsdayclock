package com.ddclock.doomsday.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WordSearchDto implements Serializable {

    @NotNull(message = "Поле не должно быть null")
    @NotBlank(message = "Поле не должно быть пустым")
    private String word;
}
