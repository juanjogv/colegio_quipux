package com.colegioquipux.backend.models.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SignInDTO implements Serializable {
	
	private static final long serialVersionUID = 3597491489649047299L;
	
	private String userNickname;
    private String userPassword;
}
