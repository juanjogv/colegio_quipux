package com.colegioquipux.backend.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id", nullable = false)
    private Integer id;

    @Column(name = "grade_name", nullable = false, length = 100)
    private String gradeName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "grade_leader", nullable = false)
    private Teacher gradeLeader;

    @Column(name = "is_active", nullable = false)
    private String isActive;

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Teacher getGradeLeader() {
        return gradeLeader;
    }

    public void setGradeLeader(Teacher gradeLeader) {
        this.gradeLeader = gradeLeader;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}