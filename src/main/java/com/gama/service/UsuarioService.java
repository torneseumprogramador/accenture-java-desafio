package com.gama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gama.exception.LoginExistenteException;
import com.gama.model.Conta;
import com.gama.model.Usuario;
import com.gama.repository.ContaRepository;
import com.gama.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public void criarContaPadrao() {
		 Usuario usuario = new Usuario();
         usuario.setCpf("00000000000");
         usuario.setNome("CONTA MASTER");
         usuario.setLogin("MASTER");
         usuario.setSenha("MASTER");
         
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
		
		repository.save(usuario);
		contaRepository.save(conta);
		
	}
}
