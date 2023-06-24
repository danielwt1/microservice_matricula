package com.acelerati.microservice.microservice_matricula.domain.model;

public class CourseModel {
    private Long idCourse;
    private Long idMateria;
    private Long idProfessor;
    private AcademicSemesterModel idAcademicSemester;
    private String group;
    private  String state;

    public CourseModel() {
    }

    public CourseModel(Long idCourse, Long idMateria, Long idProfessor, AcademicSemesterModel idAcademicSemester, String group, String state) {
        this.idCourse = idCourse;
        this.idMateria = idMateria;
        this.idProfessor = idProfessor;
        this.idAcademicSemester = idAcademicSemester;
        this.group = group;
        this.state = state;
    }

    public Long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public Long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
    }

    public AcademicSemesterModel getIdAcademicSemester() {
        return idAcademicSemester;
    }

    public void setIdAcademicSemester(AcademicSemesterModel idAcademicSemester) {
        this.idAcademicSemester = idAcademicSemester;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
