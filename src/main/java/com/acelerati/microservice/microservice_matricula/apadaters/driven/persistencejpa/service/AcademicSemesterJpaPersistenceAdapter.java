package com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.service;

import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.mappers.entity.AcademicSemesterEntityMapper;
import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.repository.AcademicSemesterRepository;
import com.acelerati.microservice.microservice_matricula.domain.model.AcademicSemesterModel;
import com.acelerati.microservice.microservice_matricula.domain.ports.spi.AcademicSemesterPersistencePort;

public class AcademicSemesterJpaPersistenceAdapter implements AcademicSemesterPersistencePort {
    private final AcademicSemesterRepository academicSemesterRepository;
    private final AcademicSemesterEntityMapper academicSemesterEntityMapper;

    public AcademicSemesterJpaPersistenceAdapter(AcademicSemesterRepository academicSemesterRepository, AcademicSemesterEntityMapper academicSemesterEntityMapper) {
        this.academicSemesterRepository = academicSemesterRepository;
        this.academicSemesterEntityMapper = academicSemesterEntityMapper;
    }

    @Override
    public AcademicSemesterModel save(AcademicSemesterModel academicSemesterModel) {
        return this.academicSemesterEntityMapper.toModel(this.academicSemesterRepository.save(this.academicSemesterEntityMapper.toEntity(academicSemesterModel)));
    }
}
