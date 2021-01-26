package com.gama.dto;

import java.time.LocalDate;

import com.gama.model.TipoMovimento;

import io.swagger.annotations.ApiModelProperty;

public class LancamentoDto {
	@ApiModelProperty(value = "Data do Lançamento", example = "2020-01-01")
	public LocalDate data; 
	
	@ApiModelProperty(value = "Valor do Lançamento", example = "10.12")
	public Double valor;
	
	@ApiModelProperty(value = "ID da Conta", example = "1")
	public Integer conta;
	
	@ApiModelProperty(value = "Data do Lançamento", example = "2020-01-01")
	public String contaDestino;
	
	@ApiModelProperty(value = "Descrição do Lançamento", example = "PAGAMENTO CONTA LUZ")
	public String descricao;
	
	@ApiModelProperty(value = "ID do Plano de Contas pertinente com a finalidade do lançamento ", example = "1")
	public Integer planoConta;
	
	@ApiModelProperty(value = "Tipo do Movimento", allowableValues = "R, D, T", example = "R")
	public TipoMovimento tipo;
}
