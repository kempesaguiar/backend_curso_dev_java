package br.com.kca.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LocacaoNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public LocacaoNotFoundException(Long id) {
		super(String.format("Locacao nao encontrada", id));
	}

}
