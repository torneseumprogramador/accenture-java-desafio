package com.gama.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gama.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
	Conta findByNumero(String numero);
	
}
