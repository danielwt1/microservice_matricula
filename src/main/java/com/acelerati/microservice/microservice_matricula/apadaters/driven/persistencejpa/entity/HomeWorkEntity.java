package com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "homework")
@Entity
public class HomeWorkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHomework;
    @ManyToOne
    @JoinColumn(name = "idCourse", nullable = false)
    private CourseEntity curso;
    private String descripcion;

    public HomeWorkEntity() {
    }

    public HomeWorkEntity(Long idHomework, CourseEntity course, String descripcion) {
        this.idHomework = idHomework;
        this.curso = course;
        this.descripcion = descripcion;
    }

    public Long getIdHomework() {
        return idHomework;
    }

    public void setIdHomework(Long idHomework) {
        this.idHomework = idHomework;
    }

    public CourseEntity getCourse() {
        return curso;
    }

    public void setCourse(CourseEntity course)
    {
        this.curso = course;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
