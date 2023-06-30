package com.acelerati.microservice.microservice_matricula.apadaters.driven.feingadapter.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResponseDTO {
    private Long idUser;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Long code;
    private Long userType;
}
