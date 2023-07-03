package com.acelerati.microservice.microservice_matricula.adapters.driven.feingadapter.service;

import com.acelerati.microservice.microservice_matricula.adapters.driven.feingadapter.client.AcademiaFeingClient;
import com.acelerati.microservice.microservice_matricula.adapters.driven.feingadapter.dto.response.SchoolSubjectDTO;
import com.acelerati.microservice.microservice_matricula.domain.ports.spi.AcademicaServiceFeingPort;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class AcademiaFeingAdapter implements AcademicaServiceFeingPort {

    private final AcademiaFeingClient academiaFeingClient;

    public AcademiaFeingAdapter(AcademiaFeingClient academiaFeingClient) {
        this.academiaFeingClient = academiaFeingClient;
    }

    @CircuitBreaker(name = "academicaService", fallbackMethod = "existMateriaFallback")
    @Override
    public boolean existMateria(Long idMateria) {
        ResponseEntity<SchoolSubjectDTO>response =academiaFeingClient.getSchoolSubjectById(idMateria);
        if(response.getStatusCode()!= HttpStatus.OK){
            return false;
        }
        Optional<SchoolSubjectDTO> schoolSubjectDTO = Optional.ofNullable(response.getBody());
        return schoolSubjectDTO.isPresent();
    }
    public boolean existMateriaFallback(Long idMateria, Throwable throwable) {
        // Código de respaldo
        return true;
    }
}
