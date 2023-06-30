package com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.service;

import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.mappers.entity.CourseEntityMapper;
import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.mappers.entity.CycleAvoidingMappingContext;
import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.repository.CourseRepository;
import com.acelerati.microservice.microservice_matricula.domain.model.CourseModel;
import com.acelerati.microservice.microservice_matricula.domain.ports.spi.CoursePersistencePort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CourseJpaPersistenceAdapter implements CoursePersistencePort {
    private final CourseRepository courseJpaRepository;
    private final CourseEntityMapper courseEntityMapper;

    public CourseJpaPersistenceAdapter(CourseRepository courseJpaRepository, CourseEntityMapper courseEntityMapper) {
        this.courseJpaRepository = courseJpaRepository;
        this.courseEntityMapper = courseEntityMapper;
    }

    @Override
    public Optional<CourseModel> findCourseById(Long idCourse) {
        return this.courseJpaRepository.findById(idCourse).map(course -> this.courseEntityMapper.toModelBidi(course, new CycleAvoidingMappingContext()));
    }

    @Override
    public void addScheduleToCourse(CourseModel course) {
        this.courseJpaRepository.save(this.courseEntityMapper.toEntity(course));
    }

    @Override
    public void createCourse(CourseModel course) {
        this.courseJpaRepository.save(this.courseEntityMapper.toEntity(course));
    }

    @Override
    public void updateCourse(CourseModel course) {
        this.courseJpaRepository.save(this.courseEntityMapper.toEntity(course));
    }

    @Override
    public List<CourseModel> getCoursesByIdTeacher(Long idTeacher) {
        return this.courseJpaRepository.findAllByIdProfessor(idTeacher)
                .stream().map(this.courseEntityMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existCourse(String group,Long idMateria,String state) {
        return this.courseJpaRepository.existsByGroupAndIdMateriaAndState(group,idMateria,state);
    }
}
