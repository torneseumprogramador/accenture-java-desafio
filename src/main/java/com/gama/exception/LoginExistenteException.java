package com.gama.exception;

public class LoginExistenteException extends Exception {
	public LoginExistenteException() {
		super();
	}
	public LoginExistenteException(String mensagem) {
		super(mensagem);
	}
}
