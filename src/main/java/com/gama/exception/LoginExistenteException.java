package com.gama.exception;

public class LoginExistenteException extends BusinessException {
	public LoginExistenteException(String login) {
		super(Erro.LOGIN_EXISTENTE_001,login);
	}
}
