package com.gama.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_lancamento")
public class Lancamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private LocalDate data; 
	
	@Column(precision = 2, scale = 9,nullable = false)
	private Double valor;
	
	@Column(nullable = false, length = 9)
	private Integer conta;
	
	@Column(nullable = false,length = 100)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "plano_conta")
	//@Column(nullable = false, length = 9)
	private PlanoConta planoConta;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false,length = 1)
	private TipoMovimento tipo;

	public Lancamento() {
		
	}
	
	public Lancamento(Integer conta, LocalDate data, String descricao, Double valor, PlanoConta planoConta,
			TipoMovimento tipo) {
		super();
		this.conta = conta;
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
		this.planoConta = planoConta;
		this.tipo = tipo;
	}

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

	public void setConta(Integer conta) {
		this.conta = conta;
	}
	public Integer getConta() {
		return conta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public PlanoConta getPlanoConta() {
		return planoConta;
	}
	public void setPlanoConta(PlanoConta planoConta) {
		this.planoConta = planoConta;
	}

	public TipoMovimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimento tipo) {
		this.tipo = tipo;
	}
	
	
}
