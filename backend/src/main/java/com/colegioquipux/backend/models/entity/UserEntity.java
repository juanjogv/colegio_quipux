package com.colegioquipux.backend.models.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.colegioquipux.backend.models.enumtype.YN_ANSWER;

@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	private Integer id;

	@Column(name = "user_nickname", nullable = false, length = 100)
	private String userNickname;

	@Column(name = "user_email", nullable = false, length = 100)
	private String userEmail;

	@Column(name = "user_password", nullable = false, length = 200)
	private String userPassword;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_type", referencedColumnName = "user_type_id")
	private UsertypeEntity userType;

	@Column(name = "register_date", nullable = false)
	private Timestamp registerDate;

	@Column(name = "is_active", nullable = false)
	@Enumerated(EnumType.STRING)
	@Type(type = "com.colegioquipux.backend.models.enumtype.EnumTypePostgreSql")
	private YN_ANSWER isActive;

	public YN_ANSWER getIsActive() {
		return isActive;
	}

	public void setIsActive(YN_ANSWER isActive) {
		this.isActive = isActive;
	}

	public Timestamp getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	public UsertypeEntity getUserType() {
		return userType;
	}

	public void setUserType(UsertypeEntity userType) {
		this.userType = userType;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}