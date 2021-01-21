package com.gama.exception;

import com.gama.exception.config.BusinessException;
import com.gama.exception.config.Erro;

public class LoginExistenteException extends BusinessException {
	public LoginExistenteException(String login) {
		super(Erro.LOGIN_EXISTENTE_001,login);
	}
}
