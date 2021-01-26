package com.gama.model;

public enum TipoMovimento {
	//mudar a forma via sobrescrita
	R(1,"RECEITA"),
	D(-1,"DESPESA"),
	T(-1,"TRANSFERENCIA");
	private Integer fator;
	private String descricao;
	private TipoMovimento(Integer fator,String descricao) {
		this.fator=fator;
		this.descricao=descricao;
	}
	public String getDescricao() {
		return descricao;
	}
	public Integer getFator() {
		return fator;
	}
}
