package com.gama.dto;

import java.time.LocalDate;

import com.gama.model.TipoMovimento;

public class LancamentoDto {
	public LocalDate data; 
	
	public Double valor;
	
	public Integer conta;
	
	public String contaDestino;
	
	public String descricao;
	
	public Integer planoConta;
	
	public TipoMovimento tipo;
}
