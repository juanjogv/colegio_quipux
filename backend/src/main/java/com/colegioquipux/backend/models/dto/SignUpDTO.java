package com.colegioquipux.backend.models.dto;

import com.colegioquipux.backend.models.entity.UsertypeEntity;

import lombok.Data;

@Data
public class SignUpDTO {

	private String userEmail;
	private String userNickname;
	private String userPassword;
	private UsertypeEntity userType;
}
