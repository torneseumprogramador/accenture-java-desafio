package com.gama.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_conta")
public class Lancamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private LocalDate data; 
	
	@Column(nullable = false, scale = 2, precision = 9)
	private Double valor;
	
	@Column(nullable = false, length = 9)
	private Integer contaOrigem;
	
	@Column(nullable = false, length = 9)
	private Integer contaDestino;
	
	@Column(nullable = false,length = 100)
	private String descricao;
	
	@Column(nullable = false, length = 9)
	private Integer planoConta;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false,length = 1)
	private TipoLancamento tipo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Integer contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Integer getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Integer contaDestino) {
		this.contaDestino = contaDestino;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getPlanoConta() {
		return planoConta;
	}

	public void setPlanoConta(Integer planoConta) {
		this.planoConta = planoConta;
	}

	public TipoLancamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoLancamento tipo) {
		this.tipo = tipo;
	}
	
	
}
