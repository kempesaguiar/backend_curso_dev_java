package br.com.kca.api.services;

import java.util.List;

import br.com.kca.api.dto.ClientCreateDTO;
import br.com.kca.api.dto.ClienteShowDTO;
import br.com.kca.api.dto.LoginDTO;
import br.com.kca.api.exception.ClienteNotFoundException;

public interface ClienteService {
	
	// Lista todos clientes
	List<ClienteShowDTO> listar();
	
	ClienteShowDTO createCliente(ClientCreateDTO clientCreateDTO);
	
	ClienteShowDTO listaClienteUnico(Long id) throws ClienteNotFoundException;
	
	ClienteShowDTO atualizaCliente(Long id, ClientCreateDTO clientCreateDTO) throws ClienteNotFoundException;
	
	void excluir(Long id) throws ClienteNotFoundException;
	
	ClienteShowDTO login(LoginDTO loginDTO) throws ClienteNotFoundException;

	
	
}
