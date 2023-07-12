package com.ajustadoati.user.application.request.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class UserDto {
    private String id;
    private String name;
    private String email;
    private String mobil;
    private List<LocationDto> locations;
}
