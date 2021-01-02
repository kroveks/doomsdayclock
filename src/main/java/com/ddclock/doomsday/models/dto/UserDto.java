package com.ddclock.doomsday.models.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto implements Serializable {
    private Long id;
    private String email;
    private String fullName;
}
