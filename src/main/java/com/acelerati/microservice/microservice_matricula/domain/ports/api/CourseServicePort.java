package com.acelerati.microservice.microservice_matricula.domain.ports.api;

import com.acelerati.microservice.microservice_matricula.domain.model.CourseModel;
import com.acelerati.microservice.microservice_matricula.domain.model.ScheduleModel;

import java.util.List;

public interface CourseServicePort {

    void createCourse(CourseModel course);
    void assingSheduleToCourse(Long courseId, ScheduleModel scheduleModel);

    void assingTeacherToCourse(Long courseId, Long teacherId);

    List<CourseModel> findCoursesByIdTeacherandState(Long idTeacher, int page, int elementPerPage, String ascOrDesc);
}
