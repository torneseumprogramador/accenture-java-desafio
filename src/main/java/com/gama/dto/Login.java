package com.gama.dto;

import io.swagger.annotations.ApiModelProperty;

public class Login {
	@ApiModelProperty(value = "Login (Usuario) no sistema (cpf, telefone, apelido)", example = "masteruser")
	private String usuario;
	
	@ApiModelProperty(value = "Senha do usuario", example = "senh@Fort#")
	private String senha;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
