package com.gama.model;

public enum TipoMovimento {
	//mudar a forma via sobrescrita
	R(1,"RECEITA"),
	D(-1,"DESPESA"),
	TU(-1,"TRANSFERENCIA ENTRE USUARIOS"),
	TC(-1,"TRANSFERENCIA ENTRE CONTAS"),
	//MT(-1,"TRANSFERENCIA MESMA TITULARIDADE");
	;
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
