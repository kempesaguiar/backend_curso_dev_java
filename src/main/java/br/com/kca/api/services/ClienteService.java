package br.com.kca.api.services;

import java.util.List;

import br.com.kca.api.dto.ClientCreateDTO;
import br.com.kca.api.dto.ClienteShowDTO;

public interface ClienteService {
	
	List<ClienteShowDTO> listar();
	
	ClienteShowDTO createCliente(ClientCreateDTO clientCreateDTO);

}
