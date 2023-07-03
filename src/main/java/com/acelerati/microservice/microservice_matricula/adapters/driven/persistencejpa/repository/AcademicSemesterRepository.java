package com.acelerati.microservice.microservice_matricula.adapters.driven.persistencejpa.repository;

import com.acelerati.microservice.microservice_matricula.adapters.driven.persistencejpa.entity.AcademicSemesterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicSemesterRepository extends JpaRepository<AcademicSemesterEntity,Long> {
}
