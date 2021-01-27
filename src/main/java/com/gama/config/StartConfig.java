package com.gama.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gama.model.Conta;
import com.gama.model.ContaTipo;
import com.gama.repository.ContaRepository;
import com.gama.service.LancamentoService;
import com.gama.service.UsuarioService;

@Component
public class StartConfig {
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private LancamentoService lancamentoService;
	
	public void start() {
		service.criarContaPadrao("user1");
		service.criarContaPadrao("user2");
		
		//gerarLancamentosExemplo();
	}
	private void gerarLancamentosExemplo() {
		//receitas
		try {
			/*
			
			String user1= "user1";
			Conta contaUser1 = contaRepository.findByTipoAndNumero(ContaTipo.CB, user1);
			
			LancamentoDto dto = new LancamentoDto();
			//RECEITAS
			
			dto.conta=contaUser1.getId();
			dto.login=user1;
			dto.data=LocalDate.now();
			dto.valor=100.0;
			dto.planoConta=1;
			dto.descricao="RECEITAS TESTES";
			lancamentoService.confirmar(dto);
			
			
			dto = new LancamentoDto();
			dto.conta=contaUser1.getId();
			dto.login=user1;
			dto.data=LocalDate.now();
			dto.valor=50.0;
			dto.planoConta=3; //id do plano de contas com nome TRF_ENTRE_CONTAS
			dto.descricao="PAGAMENTO BOLETO";
			lancamentoService.confirmar(dto);
			
			*/
			
			
			//DEPESAS
			/*
			dto = new LancamentoDto();
			dto.conta=1;
			dto.data=LocalDate.now();
			dto.valor=50.0;
			dto.planoConta=2;
			dto.descricao="DESPESAS TESTES";
			lancamentoService.confirmar(dto);
			*/
			
			
			//TRANSFERENCIA ENTRE CONTAS
			
			//TRANSFERENCIA ENTRE USUARIOS
			
			Conta user2 = contaRepository.findByTipoAndNumero(ContaTipo.CB, "user2");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
