package com.acelerati.microservice.microservice_matricula.domain.model;

import com.acelerati.microservice.microservice_matricula.domain.exception.DayOfWeekNotFoundException;
import com.acelerati.microservice.microservice_matricula.domain.model.enums.DayOfWeekEnum;

import java.time.LocalTime;

public class ScheduleModel {
    private Long idSchedule;
    private CourseModel course;
    private LocalTime hourInit;
    private LocalTime hourEnd;
    private DayOfWeekEnum day;
    private String link;

    public ScheduleModel() {
    }

    public ScheduleModel(Long idSchedule, CourseModel course, LocalTime hourInit, LocalTime hourEnd, DayOfWeekEnum day, String link) {
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

    public CourseModel getCourse() {
        return course;
    }

    public void setCourse(CourseModel course) {
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
