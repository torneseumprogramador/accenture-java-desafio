package com.gama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gama.dto.LancamentoDto;
import com.gama.model.Conta;
import com.gama.model.Lancamento;
import com.gama.model.TipoLancamento;
import com.gama.repository.ContaRepository;
import com.gama.repository.LancamentoRepository;

@Service
public class LancamentoService {
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private LancamentoRepository repository;
	
	
	@Transactional
	public void incluir(LancamentoDto dto) {
		TipoLancamento tipo = dto.tipo;
		Double valor = dto.valor * tipo.getFator();
		Lancamento entidade = new Lancamento();
		entidade.setData(dto.data);
		entidade.setDescricao(dto.descricao);
		entidade.setPlanoConta(dto.planoConta);
		entidade.setTipo(dto.tipo);
		entidade.setValor(valor);
		entidade.setTipo(tipo);
		
		Conta origem = contaRepository.findByNumero(dto.contaOrigem);
		origem.setSaldo(origem.getSaldo() + valor);
		
		
		repository.save(entidade);
		contaRepository.save(origem);
	}
	
	
	
}
