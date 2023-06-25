package com.acelerati.microservice.microservice_matricula.domain.usecase;

import com.acelerati.microservice.microservice_matricula.domain.exception.CourseUniqueGroupSemesterException;
import com.acelerati.microservice.microservice_matricula.domain.exception.MaxTimeTablesException;
import com.acelerati.microservice.microservice_matricula.domain.exception.ResourceNotFoundException;
import com.acelerati.microservice.microservice_matricula.domain.exception.TimeInvalidExeption;
import com.acelerati.microservice.microservice_matricula.domain.model.AcademicSemesterModel;
import com.acelerati.microservice.microservice_matricula.domain.model.CourseModel;
import com.acelerati.microservice.microservice_matricula.domain.model.ScheduleModel;
import com.acelerati.microservice.microservice_matricula.domain.model.enums.TypeCourseEnum;
import com.acelerati.microservice.microservice_matricula.domain.ports.api.CourseServicePort;
import com.acelerati.microservice.microservice_matricula.domain.ports.spi.AcademicSemesterPersistencePort;
import com.acelerati.microservice.microservice_matricula.domain.ports.spi.CoursePersistencePort;

import java.time.Duration;
import java.time.LocalTime;

public class CourseUseCase implements CourseServicePort {
    private static final Long HOUR_MIN_TIME = 1L;
    private static final Long HOUR_MAX_TIME = 4L;
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

    @Override
    public void assingSheduleToCourse(Long courseId, ScheduleModel scheduleModel) {
        CourseModel course = this.coursePersistencePort.findCourseById(courseId)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("El curso con id %d no existe", courseId)));
        if(course.getSchedules().size() == 5){
            throw new MaxTimeTablesException("Se ha alcanzado el maximo de horarios que es 5");
        }
        if(scheduleModel.getHourInit().isAfter(scheduleModel.getHourEnd())){
            throw new TimeInvalidExeption("La hora inicial no  puede ser mayor o igual a la hora final");
        }
        if(!validateHours(scheduleModel.getHourInit(), scheduleModel.getHourEnd())){
            throw new TimeInvalidExeption(String.format("La duracion de la clase debe ser minimo %d  y maximo de %d horas ",HOUR_MIN_TIME,HOUR_MAX_TIME));
        }
        course.getSchedules().add(scheduleModel);
        this.coursePersistencePort.addScheduleToCourse(course);
    }
    private boolean validateHours(LocalTime init,LocalTime end){
        //Puedo guardar la diferencia
        Duration difference =  Duration.between(init,end);
        return difference.toHours() >=HOUR_MIN_TIME && difference.toHours() <= HOUR_MAX_TIME;
    }
}
