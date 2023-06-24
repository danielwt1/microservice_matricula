package com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Schema(description = "DTO request for Course",
        name = "CourseRequestDTO")
public class CourseRequestDTO {
    @Schema(description = "id que relaciona con la materia",
            example = "1")
    private Long idMateria;
    @Valid
    private AcademicSemesterRequestDTO idAcademicSemester;
    @Size(min = 1,max = 5)
    @NotNull
    @NotBlank
    @Schema(description = "Grupo al que pertenece el usuario",
            example = "AB")
    private String group;

}
