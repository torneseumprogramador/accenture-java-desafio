package com.gama.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gama.dto.Sessao;
import com.gama.model.Conta;
import com.gama.model.Usuario;
import com.gama.repository.ContaRepository;
import com.gama.repository.UsuarioRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class LoginService {
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public Sessao logar(String login, String senha) throws Exception {
		
		if (login == null || login.isEmpty() || senha.isEmpty()) {
			throw new Exception("Login e senha são requeridos");
		}
		
		Usuario usuario = repository.findByLogin(login);
		
		if (usuario == null) {
			throw new Exception("Usuario nao localizado para o login: " + login);
		}
		
		boolean senhaOk = encoder.matches(senha, usuario.getSenha());
		
		if (!senhaOk) {
			throw new Exception("Senha inválida para o login: " + login);
		}
		
		Conta conta = contaRepository.findByNumero(login);
		
		// tempo do token = 1 horas
		long tempoToken = 1 * 60 * 60 * 1000;
		Sessao sessao = new Sessao();
		sessao.setDataInicio(new Date(System.currentTimeMillis()));
		sessao.setDataFim(new Date(System.currentTimeMillis() + tempoToken));
		
		sessao.setUsuario(usuario);
		sessao.setConta(conta);
		
		
		return sessao;
	}
	
	private String getJWTToken(Sessao sessao) {
		String secretKey = "TRINEO_SECRET_KEY";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		
		String token = Jwts.builder()
				.setSubject(sessao.getUsuario().getLogin())
				.claim("idUsuario", sessao.getUsuario().getId())
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))				
				.setIssuedAt(sessao.getDataInicio())
				.setExpiration(sessao.getDataFim())
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return token;
	}
}
