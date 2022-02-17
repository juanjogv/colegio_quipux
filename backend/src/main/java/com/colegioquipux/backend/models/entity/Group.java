package com.colegioquipux.backend.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id", nullable = false)
    private Integer id;

    @Column(name = "group_name", nullable = false, length = 100)
    private String groupName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "group_leader", nullable = false)
    private Teacher groupLeader;

    @ManyToOne(optional = false)
    @JoinColumn(name = "grade_id", nullable = false)
    private Grade grade;

    @Column(name = "is_active", nullable = false)
    private String isActive;

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Teacher getGroupLeader() {
        return groupLeader;
    }

    public void setGroupLeader(Teacher groupLeader) {
        this.groupLeader = groupLeader;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}