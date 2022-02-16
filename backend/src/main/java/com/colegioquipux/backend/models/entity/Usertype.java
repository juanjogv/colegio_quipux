package com.colegioquipux.backend.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "usertypes")
public class Usertype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_type_id", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}