package com.acelerati.microservice.microservice_matricula.adapters.driven.persistencejpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "curso")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;
    private Long idMateria;
    private Long idProfessor;
    @ManyToOne()
    @JoinColumn(name = "idAcademicSemester", nullable = false)
    private AcademicSemesterEntity idAcademicSemester;
    @Column(name = "grupo")
    private String group;
    private String state;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ScheduleEntity> schedules = new ArrayList<>();

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<HomeWorkEntity> homeworks = new HashSet<>();

    public CourseEntity() {
    }

    public CourseEntity(Long idCourse, Long idMateria, Long idProfessor, AcademicSemesterEntity idAcademicSemester, String group, String state, List<ScheduleEntity> schedules, Set<HomeWorkEntity> homeworks) {
        this.idCourse = idCourse;
        this.idMateria = idMateria;
        this.idProfessor = idProfessor;
        this.idAcademicSemester = idAcademicSemester;
        this.group = group;
        this.state = state;
        this.schedules = schedules;
        this.homeworks = homeworks;
    }

    public void addSchedule(ScheduleEntity schedule) {
        this.schedules.add(schedule);
        schedule.setCourse(this);
    }

    public void addHomework(HomeWorkEntity homeWork) {
        this.homeworks.add(homeWork);
        homeWork.setCourse(this);
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

    public AcademicSemesterEntity getIdAcademicSemester() {
        return idAcademicSemester;
    }

    public void setIdAcademicSemester(AcademicSemesterEntity idAcademicSemester) {
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

    public List<ScheduleEntity> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ScheduleEntity> schedules) {
        this.schedules = schedules;
    }

    public Set<HomeWorkEntity> getHomeworks() {
        return homeworks;
    }

    public void setHomeworks(Set<HomeWorkEntity> homeworks) {
        this.homeworks = homeworks;
    }
}
