package com.gama.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_plano_conta")
public class PlanoConta {
	public static final String TRF_ENTRE_CONTAS = "TRF_ENTRE_CONTAS";
	public static final String TRF_ENTRE_USUARIOS = "TRF_ENTRE_USUARIOS";
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50)
	private String descricao;
	
	@Column(length = 20)
	private String login;
	
	@Enumerated(EnumType.STRING)
	private TipoMovimento tipoMovimento;
	
	@Column(name = "fl_padrao", length = 1)
	private boolean padrao;
	
	public PlanoConta() {
		
	}
	
	public PlanoConta(String login, String descricao, TipoMovimento tipoMovimento) {
		super();
		this.login = login;
		this.descricao = descricao;
		this.tipoMovimento = tipoMovimento;
		this.padrao = true;
	}

	public void setPadrao(boolean padrao) {
		this.padrao = padrao;
	}
	public boolean isPadrao() {
		return padrao;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoMovimento getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(TipoMovimento tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}
	
	
}
