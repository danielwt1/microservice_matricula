package com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.service.impl;

import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.request.CourseRequestDTO;
import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.request.ScheduleRequestDTO;
import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.mappers.dto.CourseModelMapper;
import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.mappers.dto.ScheduleModelMapper;
import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.service.CourseService;
import com.acelerati.microservice.microservice_matricula.domain.ports.api.CourseServicePort;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseServicePort courseServicePort;
    private final CourseModelMapper courseModelMapper;
    private final ScheduleModelMapper scheduleModelMapper;

    public CourseServiceImpl(CourseServicePort courseServicePort, CourseModelMapper courseModelMapper, ScheduleModelMapper scheduleModelMapper) {
        this.courseServicePort = courseServicePort;
        this.courseModelMapper = courseModelMapper;
        this.scheduleModelMapper = scheduleModelMapper;
    }

    @Override
    public void createCourse(CourseRequestDTO courseRequestDTO) {
        this.courseServicePort.createCourse(this.courseModelMapper.toModel(courseRequestDTO));
    }

    @Override
    public void addSchedules(Long courseId, ScheduleRequestDTO scheduleRequestDTO) {
        this.courseServicePort.assingSheduleToCourse(courseId,this.scheduleModelMapper.toModel(scheduleRequestDTO));
    }
}
