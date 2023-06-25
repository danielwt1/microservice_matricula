package com.acelerati.microservice.microservice_matricula.domain.ports.spi;

import com.acelerati.microservice.microservice_matricula.domain.model.CourseModel;

import java.util.Optional;

public interface CoursePersistencePort {
    Optional<CourseModel> findCourseById(Long idCourse);

    void addScheduleToCourse(CourseModel course);
    void createCourse(CourseModel course);
    boolean existCourse(String group,Long idMateria,String state);
}
