package com.gama.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gama.dto.LancamentoDto;
import com.gama.exception.config.BusinessException;
import com.gama.model.Conta;
import com.gama.model.ContaTipo;
import com.gama.model.Lancamento;
import com.gama.model.PlanoConta;
import com.gama.model.TipoMovimento;
import com.gama.repository.ContaRepository;
import com.gama.repository.LancamentoRepository;
import com.gama.repository.PlanoContaRepository;

@Service
public class LancamentoService {
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private LancamentoRepository repository;
	
	@Autowired
	private PlanoContaRepository planoContaRepository;
	
	@Transactional
	public void confirmar(LancamentoDto dto) {
		if(!contaRepository.existsByIdAndNumero(dto.conta, dto.login))
			throw new BusinessException("Esta Conta não pertence ao Usuario");
		
		PlanoConta pc = obterPlanoConta(dto.planoConta);
		Lancamento lancamento = criarLancamento(dto.conta, dto.data, dto.descricao, dto.valor, pc);
		inserirLancamento(lancamento);
		if(pc.getTipoMovimento() == TipoMovimento.TC) {
			Conta conta = obterConta(dto.conta);
			if(conta.getTipo()==ContaTipo.CC)
				throw new BusinessException("Conta {CREDITO} NÃO pode transferir para conta {BANCO}");
			
			conta = obterContaCredito(dto.login);
			lancamento = criarLancamento(conta.getId(), dto.data, dto.descricao, dto.valor * -1, pc);
			inserirLancamento(lancamento);
			
		}else if(pc.getTipoMovimento() == TipoMovimento.TU) {
			
			Conta conta = obterContaBanco(dto.contaDestino);
			pc = planoContaRepository.transferenciaEntreUsuarios(dto.contaDestino);
			lancamento = criarLancamento(conta.getId(), dto.data, dto.descricao, dto.valor * -1, pc);
			inserirLancamento(lancamento);
			
		}
	}
	private PlanoConta obterPlanoConta(Integer planoConta) {
		Optional<PlanoConta> opc = planoContaRepository.findById(planoConta);
		if(opc.isEmpty())
			throw new BusinessException("Não existe Plano de Contas com o ID.: " + planoConta);
		
		return opc.get();
	}
	private Conta obterConta(Integer conta) {
		Optional<Conta> opc = contaRepository.findById(conta);
		if(opc.isEmpty())
			throw new BusinessException("Não existe Conta com o ID.:" + conta);
		
		return opc.get();
	}
	private Conta obterContaBanco(String login) {
		return obterConta(ContaTipo.CB,login);
	}
	
	private Conta obterContaCredito(String login) {
		return obterConta(ContaTipo.CC,login);
	}
	private Conta obterConta(ContaTipo tipo,String login) {
		Conta conta = contaRepository.findByTipoAndNumero(tipo, login);
		if(conta==null)
			throw new BusinessException("Não existe Conta com o Login" + login);
		
		return conta;
	}
	private Lancamento criarLancamento(Integer conta, LocalDate data, String descricao, Double valor, PlanoConta planoConta) {
		return criarLancamento(conta, data, descricao, valor, planoConta, null);
	}
	private Lancamento criarLancamento(Integer conta, LocalDate data, String descricao, Double valor, PlanoConta planoConta, TipoMovimento tipo) {
		Lancamento lancamento = new Lancamento();
		if(tipo==null)
			tipo=planoConta.getTipoMovimento();
		
		lancamento.setConta(conta);
		lancamento.setData(data);
		lancamento.setPlanoConta(planoConta);
		lancamento.setTipo(tipo);
		lancamento.setDescricao(descricao);
		
		lancamento.setValor(valor * tipo.getFator());
		
		return lancamento;
		
	}
	
	
	private void inserirLancamento(Lancamento lancamento) {
		repository.save(lancamento);
		Conta conta = obterConta(lancamento.getConta());
		conta.setSaldo(conta.getSaldo() + lancamento.getValor());
		contaRepository.save(conta);
	}
	
}
