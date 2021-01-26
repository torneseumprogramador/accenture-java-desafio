package com.gama.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gama.dto.UsuarioDto;
import com.gama.model.Usuario;
import com.gama.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
	@Autowired
	private UsuarioService service;
	
	@PostMapping()
	public void criarConta(@RequestBody UsuarioDto body) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setCpf(body.getCpf());
		usuario.setLogin(body.getLogin());
		usuario.setNome(body.getNome());
		usuario.setSenha(body.getSenha());
		service.criarConta(usuario);
	}
	
}
