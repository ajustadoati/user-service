package com.ajustadoati.user.application.request;

import com.ajustadoati.user.application.request.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUserRequest {
    @NotNull
    private UserDto userDto;

    public CreateUserRequest(@JsonProperty("user") @NotNull final UserDto userDto) {
        this.userDto = userDto;
    }

}
