package com.acelerati.microservice.microservice_matricula.configuration;

import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.mappers.entity.AcademicSemesterEntityMapper;
import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.mappers.entity.CourseEntityMapper;
import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.repository.AcademicSemesterRepository;
import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.repository.CourseRepository;
import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.service.AcademicSemesterPersistenceAdapter;
import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.service.CourseJpaPersistenceAdapter;
import com.acelerati.microservice.microservice_matricula.domain.ports.api.CourseServicePort;
import com.acelerati.microservice.microservice_matricula.domain.ports.spi.AcademicSemesterPersistencePort;
import com.acelerati.microservice.microservice_matricula.domain.ports.spi.CoursePersistencePort;
import com.acelerati.microservice.microservice_matricula.domain.usecase.CourseUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {
    private final CourseRepository courseJpaRepository;
    private final CourseEntityMapper courseEntityMapper;


    private final AcademicSemesterRepository academicSemesterRepository;
    private final AcademicSemesterEntityMapper academicSemesterEntityMapper;

    public BeansConfiguration(CourseRepository courseJpaRepository, CourseEntityMapper courseEntityMapper, AcademicSemesterRepository academicSemesterRepository, AcademicSemesterEntityMapper academicSemesterEntityMapper) {
        this.courseJpaRepository = courseJpaRepository;
        this.courseEntityMapper = courseEntityMapper;
        this.academicSemesterRepository = academicSemesterRepository;
        this.academicSemesterEntityMapper = academicSemesterEntityMapper;
    }

    @Bean
    public CoursePersistencePort getCoursePersistencePort() {
        return new CourseJpaPersistenceAdapter(courseJpaRepository, courseEntityMapper);
    }
    @Bean
    public AcademicSemesterPersistencePort getAcademicSemesterPersistencePort() {
        return new AcademicSemesterPersistenceAdapter(academicSemesterRepository, academicSemesterEntityMapper);
    }
    @Bean
    public CourseServicePort getCourseServicePort() {
        return new CourseUseCase(getCoursePersistencePort(), getAcademicSemesterPersistencePort());
    }
}
