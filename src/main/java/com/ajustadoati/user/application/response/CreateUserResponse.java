package com.ajustadoati.user.application.response;

import lombok.Data;

@Data
public class CreateUserResponse {
    private final String id;

    public CreateUserResponse(final String id) {
        this.id = id;
    }

}
