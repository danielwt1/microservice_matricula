package com.acelerati.microservice.microservice_matricula.domain.model;

import java.time.LocalDate;

public class AcademicSemesterModel {
    private Long idAcamedicSemester;
    private Integer number;
    private String year;
    private LocalDate initDate;
    private LocalDate endDate;

    public AcademicSemesterModel() {
    }

    public AcademicSemesterModel(Long idAcamedicSemester, Integer number, String year, LocalDate initDate, LocalDate endDate) {
        this.idAcamedicSemester = idAcamedicSemester;
        this.number = number;
        this.year = year;
        this.initDate = initDate;
        this.endDate = endDate;
    }

    public Long getIdAcamedicSemester() {
        return idAcamedicSemester;
    }

    public void setIdAcamedicSemester(Long idAcamedicSemester) {
        this.idAcamedicSemester = idAcamedicSemester;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public LocalDate getInitDate() {
        return initDate;
    }

    public void setInitDate(LocalDate initDate) {
        this.initDate = initDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
