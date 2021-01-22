package com.gama.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gama.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {
	
}
