package com.gama.dto;

import java.time.LocalDate;

import com.gama.model.TipoLancamento;

public class LancamentoDto {
	private LocalDate data; 
	
	private Double valor;
	
	private String contaOrigem;
	
	private String contaDestino;
	
	private String descricao;
	
	private Integer planoConta;
	
	private TipoLancamento tipo;
}
