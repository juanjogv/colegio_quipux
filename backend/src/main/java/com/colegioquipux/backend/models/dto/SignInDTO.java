package com.colegioquipux.backend.models.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SignInDTO implements Serializable {

	private static final long serialVersionUID = 3597491489649047299L;

	private String username;
	private String password;
}
