package com.gama.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gama.model.PlanoConta;

public interface PlanoContaRepository extends JpaRepository<PlanoConta, Integer> {
	List<PlanoConta> findByLogin(String login);
}
