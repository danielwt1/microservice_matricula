package com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.service.impl;

import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.request.CourseRequestDTO;
import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.mappers.dto.CourseModelMapper;
import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.service.CourseService;
import com.acelerati.microservice.microservice_matricula.domain.ports.api.CourseServicePort;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseServicePort courseServicePort;
    private final CourseModelMapper courseModelMapper;

    public CourseServiceImpl(CourseServicePort courseServicePort, CourseModelMapper courseModelMapper) {
        this.courseServicePort = courseServicePort;
        this.courseModelMapper = courseModelMapper;
    }

    @Override
    public void CreateCourse(CourseRequestDTO courseRequestDTO) {
        this.courseServicePort.createCourse(this.courseModelMapper.toModel(courseRequestDTO));
    }
}
