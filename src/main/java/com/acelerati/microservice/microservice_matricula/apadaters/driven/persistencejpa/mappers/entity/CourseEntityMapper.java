package com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.mappers.entity;

import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.entity.CourseEntity;
import com.acelerati.microservice.microservice_matricula.domain.model.CourseModel;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

//Para mapear bidireaccional se añade 1. que use el mapper de la otra entidad que genera el codigo, para que no lo regenere aca
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        uses = {ScheduleEntityMapper.class, AcademicSemesterEntityMapper.class})
public interface CourseEntityMapper {
    CourseEntity toEntityBidi(CourseModel courseModel, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @InheritInverseConfiguration(name = "toEntityBidi")//le tengo que decir cual usar
    CourseModel toModelBidi(CourseEntity courseEntity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    CourseModel toModel(CourseEntity courseEntity);

    CourseEntity toEntity(CourseModel courseModel);

}
