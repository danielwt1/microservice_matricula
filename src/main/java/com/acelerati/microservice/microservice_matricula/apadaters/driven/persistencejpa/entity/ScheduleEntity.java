package com.acelerati.microservice.microservice_matricula.apadaters.driven.persistencejpa.entity;

import com.acelerati.microservice.microservice_matricula.domain.model.CourseModel;
import com.acelerati.microservice.microservice_matricula.domain.model.enums.DayOfWeekEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalTime;
@Entity
@Table(name = "horario")
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSchedule;
    @ManyToOne()
    @JoinColumn(name = "idCourse", nullable = false)
    private CourseEntity course;
    private LocalTime hourInit;
    private LocalTime hourEnd;
    @Enumerated(EnumType.STRING)
    private DayOfWeekEnum day;
    private String link;

    public ScheduleEntity() {
    }

    public ScheduleEntity(Long idSchedule, CourseEntity course, LocalTime hourInit, LocalTime hourEnd, DayOfWeekEnum day, String link) {
        this.idSchedule = idSchedule;
        this.course = course;
        this.hourInit = hourInit;
        this.hourEnd = hourEnd;
        this.day = day;
        this.link = link;
    }

    public Long getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(Long idSchedule) {
        this.idSchedule = idSchedule;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public LocalTime getHourInit() {
        return hourInit;
    }

    public void setHourInit(LocalTime hourInit) {
        this.hourInit = hourInit;
    }

    public LocalTime getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(LocalTime hourEnd) {
        this.hourEnd = hourEnd;
    }

    public DayOfWeekEnum getDay() {
        return day;
    }

    public void setDay(DayOfWeekEnum day) {
        this.day = day;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
