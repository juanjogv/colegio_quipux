package com.colegioquipux.backend.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
public class GroupEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id", nullable = false)
	private Integer id;

	@Column(name = "group_name", nullable = false, length = 100)
	private String groupName;

	@ManyToOne(optional = false)
	@JoinColumn(name = "group_leader", nullable = false)
	private TeacherEntity groupLeader;

	@ManyToOne(optional = false)
	@JoinColumn(name = "grade_id", nullable = false)
	private GradeEntity grade;

	@Column(name = "is_active", nullable = false)
	private String isActive;

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public GradeEntity getGrade() {
		return grade;
	}

	public void setGrade(GradeEntity grade) {
		this.grade = grade;
	}

	public TeacherEntity getGroupLeader() {
		return groupLeader;
	}

	public void setGroupLeader(TeacherEntity groupLeader) {
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