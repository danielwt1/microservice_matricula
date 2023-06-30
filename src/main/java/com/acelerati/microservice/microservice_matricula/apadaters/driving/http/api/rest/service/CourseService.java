package com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.service;

import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.request.CourseRequestDTO;
import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.request.ScheduleRequestDTO;

public interface CourseService {

    void createCourse(CourseRequestDTO courseRequestDTO);

    void addSchedules(Long courseId, ScheduleRequestDTO scheduleRequestDTO);
}
