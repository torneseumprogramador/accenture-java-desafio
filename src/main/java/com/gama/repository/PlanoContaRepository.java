package com.gama.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gama.model.PlanoConta;

public interface PlanoContaRepository extends JpaRepository<PlanoConta, Integer> {
	public static final String SQL_PC_TRANSFERENCIA = "SELECT pc FROM PlanoConta pc WHERE pc.login = :login AND pc.descricao = '%s'";
	public static final String SQL_CONTAS = String.format(SQL_PC_TRANSFERENCIA, PlanoConta.TRF_ENTRE_CONTAS);
	
	List<PlanoConta> findByLogin(String login);
	
	@Query("SELECT pc FROM PlanoConta pc WHERE pc.login = :login AND pc.descricao = '" + PlanoConta.TRF_ENTRE_CONTAS + "'")
	PlanoConta transferenciaEntreContas(@Param("login") String login);
	
	@Query("SELECT pc FROM PlanoConta pc WHERE pc.login = :login AND pc.descricao = '" + PlanoConta.TRF_ENTRE_USUARIOS + "'")
	PlanoConta transferenciaEntreUsuarios(@Param("login") String login);
	
}
