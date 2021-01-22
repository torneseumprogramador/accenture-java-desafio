package com.gama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gama.dto.LancamentoDto;
import com.gama.model.Lancamento;
import com.gama.repository.ContaRepository;
import com.gama.repository.LancamentoRepository;

@Service
public class LancamentoService {
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private LancamentoRepository repository;
	
	public void incluir(LancamentoDto dto) {
		Lancamento entidade = new Lancamento();
		entidade.setData(dto.data);
		entidade.setDescricao(dto.descricao);
		entidade.setPlanoConta(dto.planoConta);
		entidade.setTipo(dto.tipo);
		entidade.setValor(dto.valor);
		
	}
	
}
