package com.acelerati.microservice.microservice_matricula.adapters.driving.http.api.rest.mappers.dto;

import com.acelerati.microservice.microservice_matricula.adapters.driving.http.api.rest.dto.request.HomeWorkRequestDTO;
import com.acelerati.microservice.microservice_matricula.domain.model.HomeWorkModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface HomeWorkModelMapper {
    HomeWorkModel toModel(HomeWorkRequestDTO homeWorkRequestDTO);
    HomeWorkRequestDTO toDTO(HomeWorkModel homeWorkModel);

}
