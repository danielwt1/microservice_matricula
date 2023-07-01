package com.acelerati.microservice.microservice_matricula.domain.usecase;

import com.acelerati.microservice.microservice_matricula.domain.exception.CourseException;
import com.acelerati.microservice.microservice_matricula.domain.exception.CourseUniqueGroupSemesterException;
import com.acelerati.microservice.microservice_matricula.domain.exception.DateTimeException;
import com.acelerati.microservice.microservice_matricula.domain.exception.MaxHomeWorksCourseException;
import com.acelerati.microservice.microservice_matricula.domain.exception.MaxTimeTablesException;
import com.acelerati.microservice.microservice_matricula.domain.exception.ResourceNotFoundException;
import com.acelerati.microservice.microservice_matricula.domain.exception.TimeInvalidExeption;
import com.acelerati.microservice.microservice_matricula.domain.model.AcademicSemesterModel;
import com.acelerati.microservice.microservice_matricula.domain.model.CourseModel;
import com.acelerati.microservice.microservice_matricula.domain.model.HomeWorkModel;
import com.acelerati.microservice.microservice_matricula.domain.model.ScheduleModel;
import com.acelerati.microservice.microservice_matricula.domain.model.enums.TypeCourseEnum;
import com.acelerati.microservice.microservice_matricula.domain.ports.api.CourseServicePort;
import com.acelerati.microservice.microservice_matricula.domain.ports.spi.AcademicSemesterPersistencePort;
import com.acelerati.microservice.microservice_matricula.domain.ports.spi.AcademicaServiceFeingPort;
import com.acelerati.microservice.microservice_matricula.domain.ports.spi.CoursePersistencePort;
import com.acelerati.microservice.microservice_matricula.domain.ports.spi.HomeWorkPersistencePort;
import com.acelerati.microservice.microservice_matricula.domain.ports.spi.UserServiceFeingPort;
import com.acelerati.microservice.microservice_matricula.domain.util.DomainUtilsMethods;

import java.util.List;


public class CourseUseCase implements CourseServicePort {
    private static final Long HOUR_MIN_TIME = 1L;
    private static final Long HOUR_MAX_TIME = 4L;
    private static final Long TYPE_ROLE_USER_TEACHER = 3L ;
    private static final Long WEEKS_SEMESTER_DURATION = 18L;
    private final CoursePersistencePort coursePersistencePort;
    private final AcademicSemesterPersistencePort academicSemesterPersistencePort;
    private final AcademicaServiceFeingPort academicaServiceFeingPort;
    private final UserServiceFeingPort userServiceFeingPort;

    private final HomeWorkPersistencePort homeWorkPersistencePort;

    public CourseUseCase(CoursePersistencePort coursePersistencePort, AcademicSemesterPersistencePort academicSemesterPersistencePort, AcademicaServiceFeingPort academicaServiceFeingPort, UserServiceFeingPort userServiceFeingPort, HomeWorkPersistencePort homeWorkPersistencePort) {
        this.coursePersistencePort = coursePersistencePort;
        this.academicSemesterPersistencePort = academicSemesterPersistencePort;
        this.academicaServiceFeingPort = academicaServiceFeingPort;
        this.userServiceFeingPort = userServiceFeingPort;
        this.homeWorkPersistencePort = homeWorkPersistencePort;
    }

    @Override
    public void createCourse(CourseModel course) {
        if(!this.academicaServiceFeingPort.existMateria(course.getIdMateria())){
            throw new ResourceNotFoundException(String.format("La materia con id %d no existe", course.getIdMateria()));
        }
        if(this.coursePersistencePort.existCourse(course.getGroup(),course.getIdMateria(), TypeCourseEnum.EN_CURSO.getDescription())){
            throw new CourseUniqueGroupSemesterException("Ya existe un curso con ese grupo y materia");
        }
        if(course.getIdAcademicSemester().getInitDate().isAfter(course.getIdAcademicSemester().getEndDate())){
            throw new DateTimeException("La fecha inicial no puede ser mayor que la final ");
        }
        if(!DomainUtilsMethods.validateDates(course.getIdAcademicSemester().getInitDate(),course.getIdAcademicSemester().getEndDate(),
                WEEKS_SEMESTER_DURATION)){
            throw  new DateTimeException("La fecha final de la materia debe ser de 18 semanas a 20 semanas");
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
        if(!DomainUtilsMethods.validateHours(scheduleModel.getHourInit(), scheduleModel.getHourEnd(),HOUR_MIN_TIME,HOUR_MAX_TIME)){
            throw new TimeInvalidExeption(String.format("La duracion de la clase debe ser minimo %d  y maximo de %d horas ",HOUR_MIN_TIME,HOUR_MAX_TIME));
        }
        course.getSchedules().add(scheduleModel);
        this.coursePersistencePort.addScheduleToCourse(course);
    }
    @Override
    public void assingTeacherToCourse(Long courseId, Long teacherId) {
        if(!this.userServiceFeingPort.existUserTeacher(teacherId,TYPE_ROLE_USER_TEACHER)){
            throw new ResourceNotFoundException(String.format("el Profesor con id %d no existe", teacherId));
        }

        CourseModel course = this.coursePersistencePort.findCourseById(courseId)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("El curso con id %d no existe", courseId)));
        if(this.coursePersistencePort.getCoursesByIdTeacher(teacherId).size()>=4){
            throw new CourseException("El profesor ya tiene 4 cursos");
        }
        course.setIdProfessor(teacherId);
        this.coursePersistencePort.updateCourse(course);
    }

    @Override
    public List<CourseModel> findCoursesByIdTeacherandState(Long idTeacher, int page, int elementPerPage, String ascOrDesc) {
        if(!this.userServiceFeingPort.existUserTeacher(idTeacher,TYPE_ROLE_USER_TEACHER)){
            throw new ResourceNotFoundException(String.format("el usuario con id %d no existe o no es un profesor", idTeacher));
        }
        return this.coursePersistencePort.getCourses(idTeacher,page,elementPerPage,ascOrDesc);
    }

    @Override
    public void createHomeworkToCourse(Long courseId, HomeWorkModel homework) {
        CourseModel course = this.coursePersistencePort.findCourseById(courseId)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("El curso con id %d no existe", courseId)));
        if(course.getHomeworks().size() == 3){
            throw new MaxHomeWorksCourseException("El curso ya tiene 3 tareas");
        }
        if(!course.getState().equals(TypeCourseEnum.EN_CURSO.getDescription())){
            throw new CourseException("El curso no esta en curso");
        }
        homework.setCourse(course);

        this.homeWorkPersistencePort.createHomeWork(homework);
    }
}
