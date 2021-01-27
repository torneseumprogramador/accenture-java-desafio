package com.gama.model;

public enum ContaTipo {
	CB("CONTA BANCO"),
	CC("CONTA CREDITO")
	;
	
	private String descricao;
	private ContaTipo(String descricao) {
		this.descricao=descricao;
	}
	public String getDescricao() {
		return descricao;
	}
}
