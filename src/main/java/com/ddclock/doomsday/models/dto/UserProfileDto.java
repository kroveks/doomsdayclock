package com.ddclock.doomsday.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDto implements Serializable {
    private Long id;
    private String fullName;
    private String password;
    private LocalDateTime persistDate;
    private Long roleId;
    private LocalDateTime lastRedactionDate;
    private String email;
    private String about;
    private String city;
    private Boolean isEnable;
}
