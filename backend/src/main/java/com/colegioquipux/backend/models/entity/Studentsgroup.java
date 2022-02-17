package com.colegioquipux.backend.models.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "studentsgroups")
public class Studentsgroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_group_id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @Column(name = "enrolling_date", nullable = false)
    private Instant enrollingDate;

    @Column(name = "is_current_group", nullable = false)
    private String isCurrentGroup;

    public String getIsCurrentGroup() {
        return isCurrentGroup;
    }

    public void setIsCurrentGroup(String isCurrentGroup) {
        this.isCurrentGroup = isCurrentGroup;
    }

    public Instant getEnrollingDate() {
        return enrollingDate;
    }

    public void setEnrollingDate(Instant enrollingDate) {
        this.enrollingDate = enrollingDate;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}