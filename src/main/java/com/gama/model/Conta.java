package com.gama.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tab_conta",uniqueConstraints=
	@UniqueConstraint(name="uk_numero_tipo", columnNames = {"numero", "tipo"})
)
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 20,nullable = false)
	private String numero;
	
	@Column(precision = 2, scale = 9,nullable = false)
	private Double saldo =  0.0;
	
	@Enumerated(EnumType.STRING)
	private ContaTipo tipo;
	
	public ContaTipo getTipo() {
		return tipo;
	}
	
	public void setTipo(ContaTipo tipo) {
		this.tipo = tipo;
	}
	public Integer getId() {
		return id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
}
