package com.ddclock.doomsday.models.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserResetPasswordDto {

    @NotNull(message = "Поле oldPassword не должно быть null")
    @NotBlank(message = "Поле oldPassword не должно быть пустым")
    private String oldPassword;

    @NotNull(message = "Поле newPassword не должно быть null")
    @NotBlank(message = "Поле newPassword не должно быть пустым")
    private String newPassword;
}
