package com.colegioquipux.backend.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "grades")
public class GradeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id", nullable = false)
    private Integer id;

    @Column(name = "grade_name", nullable = false, length = 100)
    private String gradeName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "grade_leader", nullable = false)
    private TeacherEntity gradeLeader;

    @Column(name = "is_active", nullable = false, length = 10)
    private String isActive;

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public TeacherEntity getGradeLeader() {
        return gradeLeader;
    }

    public void setGradeLeader(TeacherEntity gradeLeader) {
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