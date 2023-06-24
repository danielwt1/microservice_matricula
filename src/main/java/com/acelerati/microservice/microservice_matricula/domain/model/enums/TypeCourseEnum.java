package com.acelerati.microservice.microservice_matricula.domain.model.enums;

public enum TypeCourseEnum {
    EN_CURSO("EN CURSO"),
    FINALIZADO("FINALIZADO");
    private String description;
    TypeCourseEnum(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
