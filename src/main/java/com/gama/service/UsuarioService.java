package com.gama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gama.exception.LoginExistenteException;
import com.gama.model.Conta;
import com.gama.model.ContaTipo;
import com.gama.model.PlanoConta;
import com.gama.model.TipoMovimento;
import com.gama.model.Usuario;
import com.gama.repository.ContaRepository;
import com.gama.repository.PlanoContaRepository;
import com.gama.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private PlanoContaRepository planoContaRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public void criarContaPadrao() {
		 Usuario usuario = new Usuario();
         usuario.setCpf("00000000000");
         usuario.setNome("CONTA MASTER");
         usuario.setLogin("master");
         usuario.setSenha("master");
         
         try {
			criarConta(usuario);
		} catch (LoginExistenteException e) {
			System.out.println("CONTA PADRAO JÁ EXISTE - TUDO BEM");
		}
	}
	public void criarConta(Usuario usuario) throws LoginExistenteException{
		if(repository.existsByLogin(usuario.getLogin()))
			throw new LoginExistenteException(usuario.getLogin() );
		
		incluirUsuarioConta(usuario);
		
	}
	@Transactional
	private void incluirUsuarioConta(Usuario usuario) {
		String senhaCriptografada = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		
		Conta conta = new Conta();
		conta.setNumero(usuario.getLogin());
		conta.setSaldo(0.0d);
		conta.setTipo(ContaTipo.D);
		contaRepository.save(conta);
		
		conta = new Conta();
		conta.setNumero(usuario.getLogin());
		conta.setSaldo(0.0d);
		conta.setTipo(ContaTipo.C);
		contaRepository.save(conta);
		
		repository.save(usuario);
		
		PlanoConta pc = new PlanoConta();
		pc.setDescricao("RECEITAS");
		pc.setTipoMovimento(TipoMovimento.R);
		pc.setLogin(usuario.getLogin());
		
		planoContaRepository.save(pc);
		
		pc = new PlanoConta();
		pc.setDescricao("DESPESAS");
		pc.setTipoMovimento(TipoMovimento.D);
		pc.setLogin(usuario.getLogin());
		
		planoContaRepository.save(pc);
		
	}
}
