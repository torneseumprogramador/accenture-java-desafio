package com.gama.dto;

import java.util.List;

import com.gama.model.Conta;
import com.gama.model.Lancamento;

public class Dashboard {
	private ContaDto contaBanco;
	private ContaDto contaCredito;
	public ContaDto getContaBanco() {
		return contaBanco;
	}
	public void setContaBanco(ContaDto contaBanco) {
		this.contaBanco = contaBanco;
	}
	public ContaDto getContaCredito() {
		return contaCredito;
	}
	public void setContaCredito(ContaDto contaCredito) {
		this.contaCredito = contaCredito;
	}
	
	
}
