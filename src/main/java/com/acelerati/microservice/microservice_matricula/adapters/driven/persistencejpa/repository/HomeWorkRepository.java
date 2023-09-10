package com.acelerati.microservice.microservice_matricula.adapters.driven.persistencejpa.repository;

import com.acelerati.microservice.microservice_matricula.adapters.driven.persistencejpa.entity.HomeWorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeWorkRepository extends JpaRepository<HomeWorkEntity,Long> {
}
