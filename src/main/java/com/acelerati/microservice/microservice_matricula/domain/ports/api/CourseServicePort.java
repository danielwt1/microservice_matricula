package com.acelerati.microservice.microservice_matricula.domain.ports.api;

import com.acelerati.microservice.microservice_matricula.domain.model.CourseModel;

public interface CourseServicePort {

    void createCourse(CourseModel course);
}
