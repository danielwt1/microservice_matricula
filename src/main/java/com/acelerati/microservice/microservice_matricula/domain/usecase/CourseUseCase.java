package com.acelerati.microservice.microservice_matricula.domain.usecase;

import com.acelerati.microservice.microservice_matricula.domain.exception.CourseUniqueGroupSemesterException;
import com.acelerati.microservice.microservice_matricula.domain.model.AcademicSemesterModel;
import com.acelerati.microservice.microservice_matricula.domain.model.CourseModel;
import com.acelerati.microservice.microservice_matricula.domain.model.enums.TypeCourseEnum;
import com.acelerati.microservice.microservice_matricula.domain.ports.api.CourseServicePort;
import com.acelerati.microservice.microservice_matricula.domain.ports.spi.AcademicSemesterPersistencePort;
import com.acelerati.microservice.microservice_matricula.domain.ports.spi.CoursePersistencePort;

public class CourseUseCase implements CourseServicePort {
    private final CoursePersistencePort coursePersistencePort;
    private final AcademicSemesterPersistencePort academicSemesterPersistencePort;

    public CourseUseCase(CoursePersistencePort coursePersistencePort, AcademicSemesterPersistencePort academicSemesterPersistencePort) {
        this.coursePersistencePort = coursePersistencePort;
        this.academicSemesterPersistencePort = academicSemesterPersistencePort;
    }

    @Override
    public void createCourse(CourseModel course) {
        if(this.coursePersistencePort.existCourse(course.getGroup(),course.getIdMateria(), TypeCourseEnum.EN_CURSO.getDescription())){
            throw new CourseUniqueGroupSemesterException("Ya existe un curso con ese grupo y materia");
        }
        AcademicSemesterModel semester = this.academicSemesterPersistencePort.save(course.getIdAcademicSemester());
        course.setIdAcademicSemester(semester);
        course.setState(TypeCourseEnum.EN_CURSO.getDescription());
        this.coursePersistencePort.createCourse(course);
    }
}
