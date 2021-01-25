package com.gama.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gama.dto.NovaSenha;
import com.gama.dto.Login;
import com.gama.dto.Sessao;
import com.gama.service.LoginService;

@RestController
@RequestMapping()
public class LoginResource {
	@Autowired
	private LoginService service;
	
	@PostMapping("/login")
	public Sessao login(@RequestBody Login login) throws Exception {
		return service.logar(login);
	}
	
	@PostMapping("/altera-senha")
	public void alterarSenha(@RequestBody Login login, @RequestParam ("senhaTemporaria") String senhaTemporaria ) throws Exception {
		service.alterarSenha(login, senhaTemporaria);
	}
	
	@PostMapping("/nova-senha")
	public void solicitarNovaSenha(@RequestBody NovaSenha novaSenha) throws Exception {
		service.solicitarNovaSenha(novaSenha.getLogin(), novaSenha.getEmail());
	}
}
