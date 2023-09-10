package com.acelerati.microservice.microservice_matricula.domain.ports.spi;

import com.acelerati.microservice.microservice_matricula.domain.model.AcademicSemesterModel;

public interface AcademicSemesterPersistencePort {

    AcademicSemesterModel save(AcademicSemesterModel academicSemesterModel);


}
