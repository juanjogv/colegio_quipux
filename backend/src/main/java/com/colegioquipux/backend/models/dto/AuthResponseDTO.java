package com.colegioquipux.backend.models.dto;

import java.util.List;

import lombok.Data;

@Data
public class AuthResponseDTO {
	private String userNickName;
	private String userEmail;
	private String token;
	private List<String> userType;
	
	public AuthResponseDTO(String userNickName, String userEmail, String token, List<String> userType) {
		this.userNickName = userNickName;
		this.userEmail = userEmail;
		this.token = token;
		this.userType = userType;
	}
}
