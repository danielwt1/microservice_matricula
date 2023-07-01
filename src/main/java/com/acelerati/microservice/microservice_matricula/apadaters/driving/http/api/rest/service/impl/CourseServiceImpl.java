package com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.service.impl;

import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.request.CourseRequestDTO;
import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.request.HomeWorkRequestDTO;
import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.request.ScheduleRequestDTO;
import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.response.CourseResponseDTO;
import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.response.PaginationResponseDTO;
import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.mappers.dto.CourseModelMapper;
import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.mappers.dto.HomeWorkModelMapper;
import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.mappers.dto.ScheduleModelMapper;
import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.service.CourseService;
import com.acelerati.microservice.microservice_matricula.domain.ports.api.CourseServicePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseServicePort courseServicePort;
    private final CourseModelMapper courseModelMapper;
    private final ScheduleModelMapper scheduleModelMapper;
    private final HomeWorkModelMapper  homeWorkModelMapper;

    public CourseServiceImpl(CourseServicePort courseServicePort, CourseModelMapper courseModelMapper, ScheduleModelMapper scheduleModelMapper, HomeWorkModelMapper homeWorkModelMapper) {
        this.courseServicePort = courseServicePort;
        this.courseModelMapper = courseModelMapper;
        this.scheduleModelMapper = scheduleModelMapper;
        this.homeWorkModelMapper = homeWorkModelMapper;
    }

    @Override
    public void createCourse(CourseRequestDTO courseRequestDTO) {
        this.courseServicePort.createCourse(this.courseModelMapper.toModel(courseRequestDTO));
    }

    @Override
    public void addSchedules(Long courseId, ScheduleRequestDTO scheduleRequestDTO) {
        this.courseServicePort.assingSheduleToCourse(courseId,this.scheduleModelMapper.toModel(scheduleRequestDTO));
    }

    @Override
    public void addTeacherToCourse(Long courseId, Long teacherId) {
        this.courseServicePort.assingTeacherToCourse(courseId,teacherId);
    }

    @Override
    public PaginationResponseDTO<List<CourseResponseDTO>> getcourses(Long idTeacher, int page, int size, String sort) {
        List<CourseResponseDTO> response = this.courseModelMapper.toListDTO(this.courseServicePort.findCoursesByIdTeacherandState(idTeacher,page,size,sort));
        return new PaginationResponseDTO<>(page,size,sort,response);
    }

    @Override
    public void addHomeworkToCourse(Long courseId, HomeWorkRequestDTO homework) {
        this.courseServicePort.createHomeworkToCourse(courseId,this.homeWorkModelMapper.toModel(homework));
    }
}
