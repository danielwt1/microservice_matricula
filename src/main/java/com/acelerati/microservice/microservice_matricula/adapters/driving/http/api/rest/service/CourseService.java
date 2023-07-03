package com.acelerati.microservice.microservice_matricula.adapters.driving.http.api.rest.service;

import com.acelerati.microservice.microservice_matricula.adapters.driving.http.api.rest.dto.request.CourseRequestDTO;
import com.acelerati.microservice.microservice_matricula.adapters.driving.http.api.rest.dto.request.HomeWorkRequestDTO;
import com.acelerati.microservice.microservice_matricula.adapters.driving.http.api.rest.dto.request.ScheduleRequestDTO;
import com.acelerati.microservice.microservice_matricula.adapters.driving.http.api.rest.dto.response.CourseResponseDTO;
import com.acelerati.microservice.microservice_matricula.adapters.driving.http.api.rest.dto.response.PaginationResponseDTO;

import java.util.List;

public interface CourseService {

    void createCourse(CourseRequestDTO courseRequestDTO);

    void addSchedules(Long courseId, ScheduleRequestDTO scheduleRequestDTO);

    void addTeacherToCourse(Long courseId, Long teacherId);

    PaginationResponseDTO<List<CourseResponseDTO>> getcourses(Long idTeacher, int page, int size, String sort);

    void addHomeworkToCourse(Long courseId, HomeWorkRequestDTO homework);
}
