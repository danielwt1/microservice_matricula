package com.acelerati.microservice.microservice_matricula.adapters.driven.persistencejpa.service;

import com.acelerati.microservice.microservice_matricula.adapters.driven.persistencejpa.entity.CourseEntity;
import com.acelerati.microservice.microservice_matricula.adapters.driven.persistencejpa.mappers.entity.CourseEntityMapper;
import com.acelerati.microservice.microservice_matricula.adapters.driven.persistencejpa.mappers.entity.CycleAvoidingMappingContext;
import com.acelerati.microservice.microservice_matricula.adapters.driven.persistencejpa.repository.CourseRepository;
import com.acelerati.microservice.microservice_matricula.domain.model.CourseModel;
import com.acelerati.microservice.microservice_matricula.domain.ports.spi.CoursePersistencePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
    public List<CourseModel> getCoursesByIdTeacher(Long idTeacher){
        return this.courseJpaRepository.findAllByIdProfessor(idTeacher)
                .stream().map(this.courseEntityMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existCourse(String group,Long idMateria,String state) {
        return this.courseJpaRepository.existsByGroupAndIdMateriaAndState(group,idMateria,state);
    }

    @Override
    public List<CourseModel> getCourses(Long idTeacher, int page, int elementPerPage, String ascOrDesc) {
            Sort.Direction sort = ascOrDesc.equals("ASC") ? Sort.Direction.ASC:Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page,elementPerPage, Sort.by(sort,"state"));
        Page<CourseEntity> courseEntities = this.courseJpaRepository.findAllByIdProfessor(idTeacher,pageable);
        return courseEntities.getContent().stream().map(this.courseEntityMapper::toModel).collect(Collectors.toList());
    }
}
