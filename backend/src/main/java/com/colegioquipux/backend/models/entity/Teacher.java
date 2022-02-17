package com.colegioquipux.backend.models.entity;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id", nullable = false)
    private Integer id;

    @Column(name = "teacher_key", nullable = false, length = 100)
    private String teacherKey;

    @Column(name = "teacher_name", nullable = false, length = 100)
    private String teacherName;

    @Column(name = "teacher_lastname", nullable = false, length = 100)
    private String teacherLastname;

    @Column(name = "teacher_birth_date", nullable = false)
    private LocalDate teacherBirthDate;

    @Column(name = "teacher_gender", nullable = false)
    private String teacherGender;

    @Column(name = "teacher_contact_numer", nullable = false, length = 100)
    private String teacherContactNumer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "register_date", nullable = false)
    private Instant registerDate;

    @Column(name = "is_active", nullable = false)
    private String isActive;

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Instant getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Instant registerDate) {
        this.registerDate = registerDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTeacherContactNumer() {
        return teacherContactNumer;
    }

    public void setTeacherContactNumer(String teacherContactNumer) {
        this.teacherContactNumer = teacherContactNumer;
    }

    public String getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(String teacherGender) {
        this.teacherGender = teacherGender;
    }

    public LocalDate getTeacherBirthDate() {
        return teacherBirthDate;
    }

    public void setTeacherBirthDate(LocalDate teacherBirthDate) {
        this.teacherBirthDate = teacherBirthDate;
    }

    public String getTeacherLastname() {
        return teacherLastname;
    }

    public void setTeacherLastname(String teacherLastname) {
        this.teacherLastname = teacherLastname;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherKey() {
        return teacherKey;
    }

    public void setTeacherKey(String teacherKey) {
        this.teacherKey = teacherKey;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}