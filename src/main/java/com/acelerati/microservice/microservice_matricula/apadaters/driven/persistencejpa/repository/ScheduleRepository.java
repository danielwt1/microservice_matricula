package com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.repository;

import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity,Long> {
}
