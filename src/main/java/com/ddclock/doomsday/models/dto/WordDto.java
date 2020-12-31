package com.ddclock.doomsday.models.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WordDto implements Serializable {
    private Long id;
    private String value;
    private String translationValue;
    private String exampleSentence;
    private LocalDateTime persistDate;
    private LocalDateTime lastRepetition;
    private int repetitionCount;
}
