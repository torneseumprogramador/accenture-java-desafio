package com.gama.exception;

public class LoginExistenteException extends BusinessException {
	public LoginExistenteException(String login) {
		super(ERROR_ID,"001",login);
	}
}
