package com.ddclock.doomsday.models.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DictionaryCreateDto {

    @NotNull(message = "Значение userId должно быть заполнено")
    private Long userId;

    @NotNull(message = "Значение title отсутствует")
    @NotBlank(message = "Значение description не должно быть пустым")
    private String title;

    @NotNull(message = "Значение description отсутствует")
    private String description;
}
