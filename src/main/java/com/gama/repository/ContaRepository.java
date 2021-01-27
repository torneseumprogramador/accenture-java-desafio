package com.gama.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gama.model.Conta;
import com.gama.model.ContaTipo;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
	Conta findByTipoAndNumero(ContaTipo tipo, String numero);
	boolean existsByIdAndNumero(Integer id, String numero);
}
