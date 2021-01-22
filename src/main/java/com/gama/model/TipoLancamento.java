package com.gama.model;

public enum TipoLancamento {
	//mudar a forma via sobrescrita
	R(1),
	D(-1),
	T(-1);
	private Integer fator;
	
	private TipoLancamento(Integer fator) {
		this.fator=fator;
	}
	public Integer getFator() {
		return fator;
	}
}
