package com.gama.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gama.dto.Login;
import com.gama.dto.Sessao;
import com.gama.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginResource {
	@Autowired
	private LoginService service;
	
	@PostMapping()
	public Sessao login(@RequestBody Login login) throws Exception {
		return service.logar(login.getUsuario(), login.getSenha());
	}
}
