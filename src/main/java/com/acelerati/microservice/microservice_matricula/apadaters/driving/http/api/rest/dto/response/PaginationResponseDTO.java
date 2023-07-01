package com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
@Schema(description = "DTO DE respuesta ")
public class PaginationResponseDTO <T>{
    private Integer page;
    private Integer elementsPerPage;
    private String orderType;
    private T data;
}
