package com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.mappers.entity;

import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.entity.HomeWorkEntity;
import com.acelerati.microservice.microservice_matricula.domain.model.HomeWorkModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", unmappedSourcePolicy = org.mapstruct.ReportingPolicy.IGNORE, unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface HomeWorkEntityMapper {
    @Mapping(target = "course", ignore = true)
    HomeWorkEntity toEntity(HomeWorkModel model);

    @Mapping(target = "course", ignore = true)
    HomeWorkModel toModel(HomeWorkEntity entity);

}
