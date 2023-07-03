package com.acelerati.microservice.microservice_matricula.adapters.driving.http.api.rest.dto.request;


import com.acelerati.microservice.microservice_matricula.domain.model.enums.DayOfWeekEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;

import javax.validation.constraints.Pattern;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Enumerated;


@AllArgsConstructor
@Schema(description = "DTO que permite la creacion de un horario",
        name = "ScheduleRequestDTO")
public class ScheduleRequestDTO {

    @Schema(description = "Hora inicial del horario formato 24h", example = "12:30")
    @Pattern(regexp = "^([01]?\\d|2[0-3]):[0-5]\\d$", message = "El formato de hora debe ser HH:mm")
    private String hourInit;

    @Schema(description = "Hora final del horario formato 24h", example = "8:12")
    @Pattern(regexp = "^([01]?\\d|2[0-3]):[0-5]\\d$", message = "El formato de hora debe ser HH:mm")
    private String hourEnd;

    @Enumerated
    private DayOfWeekEnum day;

    @Schema(description = "Link de conexión a clase", example = "link.com")
    private String link;

    public DayOfWeekEnum getDay() {
        return day;
    }

    public String getLink() {
        return link;
    }

    public LocalTime getHourInit() {
        return LocalTime.parse(hourInit, DateTimeFormatter.ofPattern("H:mm"));
    }

    public LocalTime getHourEnd() {
        return LocalTime.parse(hourEnd, DateTimeFormatter.ofPattern("H:mm"));
    }
}

