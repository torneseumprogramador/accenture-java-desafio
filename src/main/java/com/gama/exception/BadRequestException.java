package com.gama.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BadRequestException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;

	public BadRequestException(String reason) {
		super(HttpStatus.BAD_REQUEST, reason);
	}

}
