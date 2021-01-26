package com.gama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gama.dto.LancamentoDto;
import com.gama.model.Conta;
import com.gama.model.Lancamento;
import com.gama.model.TipoMovimento;
import com.gama.repository.ContaRepository;
import com.gama.repository.LancamentoRepository;

@Service
public class LancamentoService {
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private LancamentoRepository repository;
	
	
	@Transactional
	public void confirmar(LancamentoDto dto) {
		TipoMovimento tipo = dto.tipo;
		Lancamento entidade =null;
		Conta conta =null;
		String descricao = dto.descricao;
		if(tipo==TipoMovimento.T) {
			entidade = new Lancamento();
			entidade.setData(dto.data);
			entidade.setDescricao("Receb.: " + dto.contaOrigem +" - " + descricao);
			entidade.setPlanoConta(dto.planoConta);
			entidade.setTipo(TipoMovimento.R);
			entidade.setValor(dto.valor);
			
			conta = contaRepository.findByNumero(dto.contaDestino);
			conta.setSaldo(conta.getSaldo() + dto.valor);
			entidade.setConta(conta.getId());
			
			contaRepository.save(conta);
			repository.save(entidade);
			
			descricao = "Transf.: " + dto.contaDestino + " - " + descricao;
		}
		
		Double valor = dto.valor * tipo.getFator();
		
		entidade = new Lancamento();
		entidade.setData(dto.data);
		entidade.setDescricao(descricao);
		entidade.setPlanoConta(dto.planoConta);
		entidade.setValor(valor);
		entidade.setTipo(tipo);
		
		conta = contaRepository.findByNumero(dto.contaOrigem);
		conta.setSaldo(conta.getSaldo() + valor);
		entidade.setConta(conta.getId());
		
		contaRepository.save(conta);
		repository.save(entidade);
		
	}
	
	
	
}
