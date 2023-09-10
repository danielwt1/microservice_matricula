package com.acelerati.microservice.microservice_matricula.adapters.driven.persistencejpa.mappers.entity;

import com.acelerati.microservice.microservice_matricula.adapters.driven.persistencejpa.entity.CourseEntity;
import com.acelerati.microservice.microservice_matricula.adapters.driven.persistencejpa.entity.HomeWorkEntity;
import com.acelerati.microservice.microservice_matricula.domain.model.CourseModel;
import com.acelerati.microservice.microservice_matricula.domain.model.HomeWorkModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", unmappedSourcePolicy = org.mapstruct.ReportingPolicy.IGNORE, unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface HomeWorkEntityMapper {
    @Mapping(target = "course", ignore = true)
    HomeWorkEntity toEntity(HomeWorkModel model);
    @Named("toEntityWithContext")
    HomeWorkEntity toEntityContext(HomeWorkModel model, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    @Mapping(target = "course", ignore = true)
    HomeWorkModel toModel(HomeWorkEntity entity);

}
