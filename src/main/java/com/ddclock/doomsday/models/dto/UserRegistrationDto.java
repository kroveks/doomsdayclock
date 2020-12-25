package com.ddclock.doomsday.models.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto  implements Serializable {
    @NotNull(message = "Значение fullName должно быть заполнено")
    public String fullName;

    @NotNull(message = "Значение email должно быть заполнено")
    @Email(message = "Заданный email не может существовать")
    public String email;

    @NotNull(message = "Значение password должно быть заполнено")
    public String password;

}
