package com.colegioquipux.backend.models.entity;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "directives")
public class DirectiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "directive_id", nullable = false)
    private Integer id;

    @Column(name = "directive_key", nullable = false, length = 100)
    private String directiveKey;

    @Column(name = "directive_name", nullable = false, length = 100)
    private String directiveName;

    @Column(name = "directive_lastname", nullable = false, length = 100)
    private String directiveLastname;

    @Column(name = "directive_birth_date", nullable = false)
    private LocalDate directiveBirthDate;

    @Column(name = "directive_gender", nullable = false)
    private String directiveGender;

    @Column(name = "directive_contact_numer", nullable = false, length = 100)
    private String directiveContactNumer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getDirectiveContactNumer() {
        return directiveContactNumer;
    }

    public void setDirectiveContactNumer(String directiveContactNumer) {
        this.directiveContactNumer = directiveContactNumer;
    }

    public String getDirectiveGender() {
        return directiveGender;
    }

    public void setDirectiveGender(String directiveGender) {
        this.directiveGender = directiveGender;
    }

    public LocalDate getDirectiveBirthDate() {
        return directiveBirthDate;
    }

    public void setDirectiveBirthDate(LocalDate directiveBirthDate) {
        this.directiveBirthDate = directiveBirthDate;
    }

    public String getDirectiveLastname() {
        return directiveLastname;
    }

    public void setDirectiveLastname(String directiveLastname) {
        this.directiveLastname = directiveLastname;
    }

    public String getDirectiveName() {
        return directiveName;
    }

    public void setDirectiveName(String directiveName) {
        this.directiveName = directiveName;
    }

    public String getDirectiveKey() {
        return directiveKey;
    }

    public void setDirectiveKey(String directiveKey) {
        this.directiveKey = directiveKey;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}