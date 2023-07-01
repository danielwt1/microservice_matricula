package com.acelerati.microservice.microservice_matricula.domain.ports.spi;

import com.acelerati.microservice.microservice_matricula.domain.model.HomeWorkModel;

public interface HomeWorkPersistencePort {

    void createHomeWork(HomeWorkModel homework);
}
