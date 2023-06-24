package com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.mappers.dto;

import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.request.CourseRequestDTO;
import com.acelerati.microservice.microservice_matricula.domain.model.CourseModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface CourseModelMapper {
    CourseModel toModel(CourseRequestDTO dto);

}
