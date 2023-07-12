package com.ajustadoati.user.application.request.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class LocationDto {
    private BigDecimal latitude;
    private BigDecimal longitude;
}
