package com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Schema(description = "DTO REQUEST para añadir un semestre académico",
        name = "AcademicSemesterRequestDTO")
public class AcademicSemesterRequestDTO {
    @Schema(description = "NÚmero del semestre",example = "1")
    private Integer number;
    @Size(min = 4, max = 4, message = "El año debe tener exactamente 4 dígitos")
    @Min(value = 2001, message = "El año debe ser mayor a 2000")
    @Pattern(regexp = "^[0-9]+$",message = "El Año  debe ser un valor numerico")
    @Schema(description = "Año del semestre",example = "2022")
    private String year;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "Fecha de inicio del semestre",example = "2023-06-06")
    private LocalDate initDate;
    @Schema(description = "Fecha de fin del semestre",example = "2023-06-06")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
}
