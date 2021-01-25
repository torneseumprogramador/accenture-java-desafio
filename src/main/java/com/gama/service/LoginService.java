package com.gama.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gama.dto.Login;
import com.gama.dto.Sessao;
import com.gama.exception.config.BusinessException;
import com.gama.model.Conta;
import com.gama.model.Usuario;
import com.gama.repository.ContaRepository;
import com.gama.repository.UsuarioRepository;
import com.gama.security.JWTConstants;

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
	
	public void alterarSenha(Login login,String senhaTemporaria) throws Exception {
		Usuario usuario = repository.findByLogin(login.getUsuario());
		
		if (usuario == null) {
			throw new BusinessException("Usuario nao localizado para o login: " + login.getUsuario());
		}
		
		if (!usuario.getSenhaTemporaria().equals(senhaTemporaria)) {
			throw new BusinessException("Senha temporaria inválida");
		}
		
		usuario.setSenhaTemporaria(null);
		
		String senhaCriptografada = encoder.encode(login.getSenha());
		usuario.setSenha(senhaCriptografada);
		
		repository.save(usuario);
		
	}
	
	public void solicitarNovaSenha(String login, String email) throws Exception {
		Usuario usuario = repository.findByLogin(login);
		
		if (usuario == null) {
			throw new BusinessException("Usuario nao localizado para o login: " + login);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		String senhaTemporaria = sdf.format(new Date());
		usuario.setSenhaTemporaria(senhaTemporaria);
		usuario.setSenha(senhaTemporaria);
		repository.save(usuario);
		
	}
	public Sessao logar(Login login) throws Exception {
		
		if (login == null || login.getUsuario().isEmpty() || login.getSenha().isEmpty()) {
			throw new BusinessException("Login e senha são requeridos");
		}
		
		Usuario usuario = repository.findByLogin(login.getUsuario());
		
		if (usuario == null) {
			throw new BusinessException("Usuario nao localizado para o login: " + login.getUsuario());
		}
		
		if (usuario.isRedefinirSenha()) {
			throw new BusinessException("Usuario precisa redefinir a senha: " + login.getUsuario());
		}
		
		boolean senhaOk = encoder.matches(login.getSenha(), usuario.getSenha());
		
		if (!senhaOk) {
			throw new BusinessException("Senha inválida para o login: " + login);
		}
		
		Conta conta = contaRepository.findByNumero(login.getUsuario());
		
		// tempo do token = 1 horas
		long tempoToken = 1 * 60 * 60 * 1000;
		Sessao sessao = new Sessao();
		sessao.setDataInicio(new Date(System.currentTimeMillis()));
		sessao.setDataFim(new Date(System.currentTimeMillis() + tempoToken));
		
		sessao.setUsuario(usuario);
		sessao.setConta(conta);
		sessao.setToken(getJWTToken(sessao));
		
		return sessao;
	}
	
	private String getJWTToken(Sessao sessao) {
		
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
				.signWith(SignatureAlgorithm.HS512, JWTConstants.KEY.getBytes()).compact();

		return token;
	}
}
