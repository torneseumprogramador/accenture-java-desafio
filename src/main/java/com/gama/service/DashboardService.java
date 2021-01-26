package com.gama.service;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
		Conta cc = contaRepository.findByTipoAndNumero(ContaTipo.C, login);
		Conta cd = contaRepository.findByTipoAndNumero(ContaTipo.D, login);
		
		dash.setContaCredito(cc);
		dash.setContaDebito(cd);
		
		dash.setContaCreditoLancamentos(lancamentoRepository.listarLancamentos(cc.getId(), inicio, fim));
		dash.setContaDebitoLancamentos(lancamentoRepository.listarLancamentos(cd.getId(), inicio, fim));
		
		
		return dash;
	}
}