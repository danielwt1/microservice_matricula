package com.acelerati.microservice.microservice_matricula.domain.ports.api;

import com.acelerati.microservice.microservice_matricula.domain.model.CourseModel;
import com.acelerati.microservice.microservice_matricula.domain.model.ScheduleModel;

public interface CourseServicePort {

    void createCourse(CourseModel course);
    void assingSheduleToCourse(Long courseId, ScheduleModel scheduleModel);
}
