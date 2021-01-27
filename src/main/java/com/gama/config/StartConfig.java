package com.gama.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gama.model.PlanoConta;
import com.gama.model.TipoMovimento;
import com.gama.repository.PlanoContaRepository;
import com.gama.service.UsuarioService;

@Component
public class StartConfig {
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private PlanoContaRepository pcRepository;
	public void start() {
		service.criarContaPadrao();
		PlanoConta pc = new PlanoConta();
		pc.setLogin("master");
		pc.setDescricao(PlanoConta.TRF_ENTRE_USUARIOS);
		pc.setTipoMovimento(TipoMovimento.T);
		pcRepository.save(pc);
	}
	
}
