package br.com.kca.api.services;

import java.util.List;

import br.com.kca.api.dto.LocacaoCreateDTO;
import br.com.kca.api.dto.ResponseLocacaoDTO;
import br.com.kca.api.exception.ClienteNotFoundException;
import br.com.kca.api.exception.FilmeNotFoundException;

public interface LocacaoService {
	
	List<ResponseLocacaoDTO> listar();
	
	ResponseLocacaoDTO createLocacao(LocacaoCreateDTO locacaoCreateDTO) throws FilmeNotFoundException, ClienteNotFoundException; 

}
