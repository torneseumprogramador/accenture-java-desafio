package com.gama.dto;

import java.util.List;

import com.gama.model.Lancamento;

public class ContaDto {
	private Double saldo;
	private Integer id;
	private List<Lancamento> lancamentos;
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
