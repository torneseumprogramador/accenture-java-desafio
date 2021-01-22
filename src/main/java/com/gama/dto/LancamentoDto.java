package com.gama.dto;

import java.time.LocalDate;

import com.gama.model.TipoLancamento;

public class LancamentoDto {
	public LocalDate data; 
	
	public Double valor;
	
	public String contaOrigem;
	
	public String contaDestino;
	
	public String descricao;
	
	public Integer planoConta;
	
	public TipoLancamento tipo;
}
