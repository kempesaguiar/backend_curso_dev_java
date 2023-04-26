package br.com.kca.api.mapper;

import org.springframework.stereotype.Component;

import br.com.kca.api.dto.ClienteShowDTO;
import br.com.kca.api.models.Cliente;

@Component
public class MapStructClienteMapperImpl implements MapStructClienteMapper {

	@Override
	public ClienteShowDTO clienteToClienteShowDTO(Cliente cliente) {
		return new ClienteShowDTO(cliente);
	}


	

}
