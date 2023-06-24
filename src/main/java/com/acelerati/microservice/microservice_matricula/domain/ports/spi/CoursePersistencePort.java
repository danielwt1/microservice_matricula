package com.acelerati.microservice.microservice_matricula.domain.ports.spi;

import com.acelerati.microservice.microservice_matricula.domain.model.CourseModel;

public interface CoursePersistencePort {

    void createCourse(CourseModel course);
    public boolean existCourse(String group,Long idMateria,String state);
}
