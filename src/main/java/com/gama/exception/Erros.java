package com.gama.exception;

public enum Erros {
	LOGIN_EXISTENTE_001("001","Já existe um login cadastrado com o nome %s")
	
	;
	
	private String codigo;
	private String mensagem;
	
	private Erros(String codigo, String mensagem) {
		this.codigo=codigo;
		this.mensagem=mensagem;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getMensagem() {
		return mensagem;
	}
	
}
