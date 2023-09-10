package com.acelerati.microservice.microservice_matricula.adapters.driving.http.api.rest.mappers.dto;

import com.acelerati.microservice.microservice_matricula.adapters.driving.http.api.rest.dto.request.ScheduleRequestDTO;
import com.acelerati.microservice.microservice_matricula.domain.model.ScheduleModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface ScheduleModelMapper {

    ScheduleRequestDTO toDTO (ScheduleModel shedule);
    ScheduleModel toModel (ScheduleRequestDTO sheduleDTO);

}
