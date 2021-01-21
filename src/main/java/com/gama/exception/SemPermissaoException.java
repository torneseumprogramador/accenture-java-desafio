package com.gama.exception;

import com.gama.exception.config.BusinessException;
import com.gama.exception.config.Erro;

public class SemPermissaoException extends BusinessException {
	public SemPermissaoException(String path) {
		super(Erro.SEM_PERMISSAO_002,path);
	}
}
