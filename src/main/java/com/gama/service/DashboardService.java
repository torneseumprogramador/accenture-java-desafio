package com.gama.service;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gama.dto.ContaDto;
import com.gama.dto.Dashboard;
import com.gama.model.Conta;
import com.gama.model.ContaTipo;
import com.gama.repository.ContaRepository;
import com.gama.repository.LancamentoRepository;

@Component
public class DashboardService {
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public Dashboard atualizarDashboard(String login, LocalDate inicio, LocalDate fim) {
		Dashboard dash = new Dashboard();
		Conta contaBanco = contaRepository.findByTipoAndNumero(ContaTipo.CB, login);
		Conta contaCredito = contaRepository.findByTipoAndNumero(ContaTipo.CC, login);
		
		ContaDto banco = new ContaDto();
		banco.setSaldo(contaBanco.getSaldo());
		banco.setLancamentos(lancamentoRepository.listarLancamentos(contaBanco.getId(), inicio, fim));
		
		ContaDto credito = new ContaDto();
		credito.setSaldo(contaCredito.getSaldo());
		credito.setLancamentos(lancamentoRepository.listarLancamentos(contaCredito.getId(), inicio, fim));
		
		
		dash.setContaBanco(banco);
		dash.setContaCredito(credito);
		return dash;
	}
}
