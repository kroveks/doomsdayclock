package com.ddclock.doomsday.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryDto implements Serializable {
    private Long id;
    private String title;
    private String description;
    private int wordCount;
}
