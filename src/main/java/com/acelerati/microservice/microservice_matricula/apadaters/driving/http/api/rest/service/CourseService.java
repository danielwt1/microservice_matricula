package com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.service;

import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.request.CourseRequestDTO;

public interface CourseService {

    void CreateCourse(CourseRequestDTO courseRequestDTO);
}
