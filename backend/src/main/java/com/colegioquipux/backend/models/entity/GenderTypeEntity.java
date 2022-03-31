package com.colegioquipux.backend.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "gender_types")
public class GenderTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gender_type_id", nullable = false)
    private Integer id;

    @Column(name = "gender_type_name", length = 100)
    private String genderTypeName;

    @Column(name = "is_active", nullable = false, length = 10)
    private String isActive;

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getGenderTypeName() {
        return genderTypeName;
    }

    public void setGenderTypeName(String genderTypeName) {
        this.genderTypeName = genderTypeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}