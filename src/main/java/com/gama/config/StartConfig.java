package com.gama.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gama.service.UsuarioService;

@Component
public class StartConfig {
	@Autowired
	private UsuarioService service;
	
	public void start() {
		service.criarContaPadrao("user1");
		service.criarContaPadrao("user2");
		
	}
	
}
