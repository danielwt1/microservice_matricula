package com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.service;

import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.mappers.entity.HomeWorkEntityMapper;
import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.repository.HomeWorkRepository;
import com.acelerati.microservice.microservice_matricula.domain.model.HomeWorkModel;
import com.acelerati.microservice.microservice_matricula.domain.ports.spi.HomeWorkPersistencePort;

public class HomeWorkJpaPersistenceAdapter implements HomeWorkPersistencePort {
    private final HomeWorkRepository homeWorkRepository;
    private final HomeWorkEntityMapper homeWorkEntityMapper;

    public HomeWorkJpaPersistenceAdapter(HomeWorkRepository homeWorkRepository, HomeWorkEntityMapper homeWorkEntityMapper) {
        this.homeWorkRepository = homeWorkRepository;
        this.homeWorkEntityMapper = homeWorkEntityMapper;
    }

    @Override
    public void createHomeWork(HomeWorkModel homework) {
        this.homeWorkRepository.save(this.homeWorkEntityMapper.toEntity(homework));
    }
}
