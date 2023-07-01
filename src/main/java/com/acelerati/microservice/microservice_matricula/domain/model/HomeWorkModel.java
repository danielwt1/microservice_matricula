package com.acelerati.microservice.microservice_matricula.domain.model;




public class HomeWorkModel {
    private Long idHomework;
    private CourseModel course;
    private String descripcion;

    public HomeWorkModel() {
    }

    public HomeWorkModel(Long idHomework, CourseModel course, String descripcion) {
        this.idHomework = idHomework;
        this.course = course;
        this.descripcion = descripcion;
    }

    public Long getIdHomework() {
        return idHomework;
    }

    public void setIdHomework(Long idHomework) {
        this.idHomework = idHomework;
    }

    public CourseModel getCourse() {
        return course;
    }

    public void setCourse(CourseModel course) {
        this.course = course;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
