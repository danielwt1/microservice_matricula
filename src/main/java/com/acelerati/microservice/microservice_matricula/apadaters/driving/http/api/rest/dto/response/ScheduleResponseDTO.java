package com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.response;

import com.acelerati.microservice.microservice_matricula.domain.model.CourseModel;
import com.acelerati.microservice.microservice_matricula.domain.model.enums.DayOfWeekEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;
@AllArgsConstructor
@Getter
@Schema(description = "DTO de respuesta para o registro de umn curso")
public class ScheduleResponseDTO {
    @Schema(description = "Identificador en curso")
    private Long id;
    @Schema(description ="Hora inicial ")
    private LocalTime hourInit;
    @Schema(description ="Hora final ")
    private LocalTime hourEnd;
    @Schema(description ="Dia ")
    private DayOfWeekEnum day;
    @Schema(description ="Link para de la clase")
    private String link;
}
