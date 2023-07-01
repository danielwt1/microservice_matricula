package com.acelerati.microservice.microservice_matricula.domain.ports.spi;

import com.acelerati.microservice.microservice_matricula.domain.model.CourseModel;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CoursePersistencePort {
    Optional<CourseModel> findCourseById(Long idCourse);

    void addScheduleToCourse(CourseModel course);
    void createCourse(CourseModel course);
    void updateCourse(CourseModel course);

    List<CourseModel> getCoursesByIdTeacher(Long idTeacher);
    boolean existCourse(String group,Long idMateria,String state);

    List<CourseModel> getCourses(Long idTeacher, int page, int elementPerPage, String ascOrDesc);
}
