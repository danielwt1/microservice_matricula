package com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.mappers.entity;

import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.entity.AcademicSemesterEntity;
import com.acelerati.microservice.microservice_matricula.domain.model.AcademicSemesterModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface AcademicSemesterEntityMapper {
    AcademicSemesterModel toModel(AcademicSemesterEntity entity);
    AcademicSemesterEntity toEntity(AcademicSemesterModel model);
}
