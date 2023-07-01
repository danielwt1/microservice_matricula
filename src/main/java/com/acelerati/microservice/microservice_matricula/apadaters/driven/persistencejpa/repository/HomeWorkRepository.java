package com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.repository;

import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.entity.HomeWorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeWorkRepository extends JpaRepository<HomeWorkEntity,Long> {
}
