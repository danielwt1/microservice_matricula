package com.acelerati.microservice.microservice_matricula.configuration;

import com.acelerati.microservice.microservice_matricula.apadaters.driven.feingadapter.client.AcademiaFeingClient;
import com.acelerati.microservice.microservice_matricula.apadaters.driven.feingadapter.service.AcademiaFeingAdapter;
import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.mappers.entity.AcademicSemesterEntityMapper;
import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.mappers.entity.CourseEntityMapper;
import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.repository.AcademicSemesterRepository;
import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.repository.CourseRepository;
import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.service.AcademicSemesterJpaPersistenceAdapter;
import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.service.CourseJpaPersistenceAdapter;
import com.acelerati.microservice.microservice_matricula.domain.ports.api.CourseServicePort;
import com.acelerati.microservice.microservice_matricula.domain.ports.spi.AcademicSemesterPersistencePort;
import com.acelerati.microservice.microservice_matricula.domain.ports.spi.AcademicaServiceFeingPort;
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
    private final AcademiaFeingClient  academiaFeingClient;

    public BeansConfiguration(CourseRepository courseJpaRepository, CourseEntityMapper courseEntityMapper, AcademicSemesterRepository academicSemesterRepository, AcademicSemesterEntityMapper academicSemesterEntityMapper, AcademiaFeingClient academiaFeingClient) {
        this.courseJpaRepository = courseJpaRepository;
        this.courseEntityMapper = courseEntityMapper;
        this.academicSemesterRepository = academicSemesterRepository;
        this.academicSemesterEntityMapper = academicSemesterEntityMapper;
        this.academiaFeingClient = academiaFeingClient;
    }

    @Bean
    public CoursePersistencePort getCoursePersistencePort() {
        return new CourseJpaPersistenceAdapter(courseJpaRepository, courseEntityMapper);
    }
    @Bean
    public AcademicSemesterPersistencePort getAcademicSemesterPersistencePort() {
        return new AcademicSemesterJpaPersistenceAdapter(academicSemesterRepository, academicSemesterEntityMapper);
    }
    @Bean
    public AcademicaServiceFeingPort getAcademicaServiceFeingPort() {
        return new AcademiaFeingAdapter(academiaFeingClient);
    }
    @Bean
    public CourseServicePort getCourseServicePort() {
        return new CourseUseCase(getCoursePersistencePort(), getAcademicSemesterPersistencePort(),getAcademicaServiceFeingPort());
    }
}
