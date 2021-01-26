package com.gama.dto;

import java.util.List;

import com.gama.model.Conta;
import com.gama.model.Lancamento;

public class DashBoard {
	private Conta contaDebito;
	private Conta contaCredito;
	private List<Lancamento> contaDebitoLancamentos;
	private List<Lancamento> contaCreditoLancamentos;
	public Conta getContaDebito() {
		return contaDebito;
	}
	public void setContaDebito(Conta contaDebito) {
		this.contaDebito = contaDebito;
	}
	public Conta getContaCredito() {
		return contaCredito;
	}
	public void setContaCredito(Conta contaCredito) {
		this.contaCredito = contaCredito;
	}
	public List<Lancamento> getContaDebitoLancamentos() {
		return contaDebitoLancamentos;
	}
	public void setContaDebitoLancamentos(List<Lancamento> contaDebitoLancamentos) {
		this.contaDebitoLancamentos = contaDebitoLancamentos;
	}
	public List<Lancamento> getContaCreditoLancamentos() {
		return contaCreditoLancamentos;
	}
	public void setContaCreditoLancamentos(List<Lancamento> contaCreditoLancamentos) {
		this.contaCreditoLancamentos = contaCreditoLancamentos;
	}
	
}
