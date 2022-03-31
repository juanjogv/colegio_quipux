package com.colegioquipux.backend.models.dto;

import java.util.List;

import lombok.Data;

@Data
public class AuthResponseDTO {
	
	private String username;
	private String email;
	private String token;
	private List<String> userType;

	public AuthResponseDTO(String username, String email, String token, List<String> userType) {
		this.username = username;
		this.email = email;
		this.token = token;
		this.userType = userType;
	}
}
