package com.ajustadoati.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class Location {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String userId;
}
