package com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.mappers.entity;

import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.entity.ScheduleEntity;
import com.acelerati.microservice.microservice_matricula.domain.model.ScheduleModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface ScheduleEntityMapper {

    ScheduleEntity toEntity(ScheduleModel scheduleModel);
    ScheduleModel toModel(ScheduleEntity scheduleEntity);

}
