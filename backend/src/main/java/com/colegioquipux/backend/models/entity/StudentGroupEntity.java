package com.colegioquipux.backend.models.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "studentsgroups")
public class StudentGroupEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_group_id", nullable = false)
	private Integer id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "student_id", nullable = false)
	private StudentEntity student;

	@ManyToOne(optional = false)
	@JoinColumn(name = "group_id", nullable = false)
	private GroupEntity group;

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

	public GroupEntity getGroup() {
		return group;
	}

	public void setGroup(GroupEntity group) {
		this.group = group;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}