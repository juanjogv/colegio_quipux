package com.colegioquipux.backend.models.dto;


import com.colegioquipux.backend.models.entity.UserTypeEntity;

import lombok.Data;


@Data
public class SignUpDTO {

	private String username;
	private String email;
	private String password;
	private UserTypeEntity userType;
}
