package com.gama.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gama.dto.LancamentoDto;
import com.gama.exception.config.BusinessException;
import com.gama.model.Conta;
import com.gama.model.ContaTipo;
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

			conta = contaRepository.findByNumero(dto.contaDestino);
			if(conta.getTipo()==ContaTipo.C)
				throw new BusinessException("Só é possível realizar entre contas do tipo débito ");
			
			entidade = new Lancamento();
			entidade.setData(dto.data);
			entidade.setDescricao("Receb.: " + descricao);
			entidade.setPlanoConta(dto.planoConta);
			entidade.setTipo(TipoMovimento.R);
			entidade.setValor(dto.valor);
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
		
		Optional<Conta> contaOp = contaRepository.findById(dto.conta);
		if(contaOp.isPresent())
			conta=contaOp.get();
		else
			throw new BusinessException("Não foi localizada uma conta com ID " + dto.conta);
		
		conta.setSaldo(conta.getSaldo() + valor);
		entidade.setConta(conta.getId());
		
		contaRepository.save(conta);
		repository.save(entidade);
		
	}
	
	
	
}
