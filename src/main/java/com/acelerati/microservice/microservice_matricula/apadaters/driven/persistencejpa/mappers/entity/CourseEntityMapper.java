package com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.mappers.entity;

import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.entity.CourseEntity;
import com.acelerati.microservice.microservice_matricula.domain.model.CourseModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CourseEntityMapper {
    CourseModel toBidirectionalModel(CourseEntity courseEntity);
    CourseEntity toBidirectionalEntity(CourseModel courseModel);

    CourseModel toModel(CourseEntity courseEntity);
    CourseEntity toEntity(CourseModel courseModel);

}
