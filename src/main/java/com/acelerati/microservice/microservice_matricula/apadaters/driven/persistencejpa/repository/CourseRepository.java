package com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.repository;

import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Long> {
    boolean existsByGroupAndIdMateriaAndState(String group,Long idMateria,String state);

    List<CourseEntity> findAllByIdProfessor(Long idProfessor);
}
