package com.acelerati.microservice.microservice_matricula.apadaters.driven.feingadapter.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SchoolSubjectDTO {
    private Long idSchoolSubject;
    private Integer idPensum;
    private String name;
    private String description;
    private SchoolSubjectDTO schoolSubject;
}
