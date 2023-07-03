package com.acelerati.microservice.microservice_matricula.adapters.driven.persistencejpa.mappers.entity;

import com.acelerati.microservice.microservice_matricula.adapters.driven.persistencejpa.entity.ScheduleEntity;
import com.acelerati.microservice.microservice_matricula.domain.model.ScheduleModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface ScheduleEntityMapper {
    @Mapping(target = "course", ignore = true)
    ScheduleEntity toEntity(ScheduleModel scheduleModel);
    List<ScheduleEntity> toListEntity(List<ScheduleModel> scheduleModelList);
    @Mapping(target = "course", ignore = true)
    ScheduleModel toModel(ScheduleEntity scheduleEntity);
    List<ScheduleModel> toListModel(List<ScheduleEntity> scheduleEntityList);

}
