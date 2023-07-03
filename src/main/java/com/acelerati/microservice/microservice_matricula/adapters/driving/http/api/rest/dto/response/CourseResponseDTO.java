package com.acelerati.microservice.microservice_matricula.adapters.driving.http.api.rest.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@AllArgsConstructor
@Getter
@Schema(description = "DTO para respuesta de curso")
public class CourseResponseDTO {
    private Long idMateria;
    private Long idProfessor;
    private AcademicSemesterResponseDTO idAcademicSemester;
    private String group;
    private  String state;
    private List<ScheduleResponseDTO> schedules;
}
