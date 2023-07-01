package com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Schema(description = "DTO para solicitud de tarea ára agragarla al curso",name = "HomeWorkRequestDTO")
public class HomeWorkRequestDTO {
    @NotNull
    @Size(min = 100,max = 300)
    @Schema(description = "Descripción de la tarea",
            example = "Tarea de prueba para agregarla al curso de microservicios de matricula  carga la tarea el espacio minimo es 100 caracteres adada")
    private String descripcion;

    public HomeWorkRequestDTO() {
    }

    public HomeWorkRequestDTO(String descripcion) {
        this.descripcion = descripcion;
    }
}
