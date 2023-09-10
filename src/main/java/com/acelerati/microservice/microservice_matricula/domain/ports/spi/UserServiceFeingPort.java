package com.acelerati.microservice.microservice_matricula.domain.ports.spi;

public interface UserServiceFeingPort {

    boolean existUserTeacher(Long idUser,Long idType);
}
