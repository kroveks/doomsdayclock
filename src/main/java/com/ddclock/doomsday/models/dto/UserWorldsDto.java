package com.ddclock.doomsday.models.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserWorldsDto implements Serializable {
    private Long id;
    private String email;
    private String fullName;
    private List<WordDto> wordDtoList;
}
