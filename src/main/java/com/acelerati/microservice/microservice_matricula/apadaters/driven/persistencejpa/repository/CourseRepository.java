package com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.repository;

import com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.entity.CourseEntity;
import com.acelerati.microservice.microservice_matricula.domain.model.CourseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Long> {
    boolean existsByGroupAndIdMateriaAndState(String group,Long idMateria,String state);

    List<CourseEntity> findAllByIdProfessor(Long idProfessor);

    Page<CourseEntity> findAllByIdProfessor(Long idTeacher, Pageable pageable);
}
