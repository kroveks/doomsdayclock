package com.ddclock.doomsday.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorldDto implements Serializable {
    private Long id;
    private String value;
    private String translationValue;
    private String exampleSentence;
    private LocalDateTime persistDate;
    private LocalDateTime lastRepetition;
    private int repetitionCount;
}
