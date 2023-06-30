package com.acelerati.microservice.microservice_matricula.apadaters.driven.feingadapter.service;

import com.acelerati.microservice.microservice_matricula.apadaters.driven.feingadapter.client.UserFeingClient;
import com.acelerati.microservice.microservice_matricula.apadaters.driven.feingadapter.dto.response.UserResponseDTO;
import com.acelerati.microservice.microservice_matricula.domain.ports.spi.UserServiceFeingPort;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class UserFeingAdapter implements UserServiceFeingPort {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserFeingAdapter.class);
    private final UserFeingClient userFeingClient;

    public UserFeingAdapter(UserFeingClient userFeingClient) {
        this.userFeingClient = userFeingClient;
    }


    @CircuitBreaker(name = "userFeingClient", fallbackMethod = "existUserTeacherFallback")
    @Override
    public boolean existUserTeacher(Long idUser, Long idType) {
        ResponseEntity<UserResponseDTO>response = userFeingClient.getUserByIdAndTypeTeacher(idUser, idType);
        Optional<UserResponseDTO> userResponse = Optional.ofNullable(response.getBody());

        return userResponse.isPresent();
    }
    public boolean existUserTeacherFallback(Long idUser, Long idType, Throwable t){
        LOGGER.error(t.getMessage());
        return true;
    }
}
