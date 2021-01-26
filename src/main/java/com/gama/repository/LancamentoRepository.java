package com.gama.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gama.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {
	 @Query("SELECT e FROM Lancamento e where e.conta = :idConta and e.data between :inicio and :fim")
    public List<Lancamento> listarLancamentos(@Param("idConta") Integer idConta, @Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);
}
