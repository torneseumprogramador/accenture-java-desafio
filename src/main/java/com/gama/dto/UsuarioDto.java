package com.gama.dto;

import io.swagger.annotations.ApiModelProperty;

public class UsuarioDto {
	@ApiModelProperty(value = "CPF", example = "00454011245")
	private String cpf;
	
	@ApiModelProperty(value = "Nome do titular", example = "MARCOS ANDRE")
	private String nome;
	
	@ApiModelProperty(value = "login de acesso (CPF, Telefone, apelido)", example = "andre")
	private String login;
	
	@ApiModelProperty(value = "Senha de acesso", example = "senha123")
	private String senha;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
