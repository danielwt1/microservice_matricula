package com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "academic_semester")
public class AcademicSemesterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAcamedicSemester;

    private Integer number;
    private String year;
    private LocalDate initDate;
    private LocalDate endDate;


    public AcademicSemesterEntity() {
    }

    public AcademicSemesterEntity(Long idAcamedicSemester, Integer number, String year, LocalDate initDate, LocalDate endDate) {
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
