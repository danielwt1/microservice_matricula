package com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.request;


import com.acelerati.microservice.microservice_matricula.domain.model.enums.DayOfWeekEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@AllArgsConstructor
@Getter
@Schema(description = "DTO que permite la creacion de un horario",
        name = "ScheduleRequestDTO")
public class ScheduleRequestDTO {

    private CourseRequestDTO course;
    @Schema(description = "Hora inicial del horario",
            example = "2023-04-12")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalTime hourInit;
    @Schema(description = "Hora final del horario",
            example = "2023-04-12")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalTime hourEnd;
    @Enumerated
    @NotNull
    private DayOfWeekEnum day;
    @Schema(description = "Linkl de conexion a clase",
            example = "link.com")
    private String link;
}
