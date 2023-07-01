package com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
@Schema(description = "DTO para representar o semestre académico")
public class AcademicSemesterResponseDTO {
    private Integer number;
    private String year;
    private LocalDate initDate;
    private LocalDate endDate;
}
