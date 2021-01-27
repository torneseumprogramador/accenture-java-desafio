package com.gama.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gama.model.PlanoConta;

public interface PlanoContaRepository extends JpaRepository<PlanoConta, Integer> {
	List<PlanoConta> findByLogin(String login);
	
	@Query("SELECT pc FROM PlanoConta pc WHERE pc.descricao = '" + PlanoConta.TRF_ENTRE_CONTAS + "'")
	PlanoConta transferenciaEntreUsuarios();
	
}
