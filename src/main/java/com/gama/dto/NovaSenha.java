package com.gama.dto;

import io.swagger.annotations.ApiModelProperty;

public class NovaSenha {
	@ApiModelProperty(value = "Login (Usuario) no sistema (cpf, telefone, apelido)", example = "11954360987")
	private String login;
	
	@ApiModelProperty(value = "E-mail que receberá", example = "11954360987")
	private String email;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
