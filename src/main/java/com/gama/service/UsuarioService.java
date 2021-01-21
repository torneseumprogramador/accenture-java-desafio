package com.gama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gama.model.Usuario;
import com.gama.repository.ContaRepository;
import com.gama.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;
	private ContaRepository contaRepository;
	
	public void criarConta(Usuario usuario) {
		
	}
}
