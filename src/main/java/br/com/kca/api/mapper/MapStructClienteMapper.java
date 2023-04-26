package br.com.kca.api.mapper;

import org.mapstruct.Mapper;

import br.com.kca.api.dto.ClienteShowDTO;
import br.com.kca.api.models.Cliente;

@Mapper(componentModel = "spring")
public interface MapStructClienteMapper {
	
	ClienteShowDTO clienteToClienteShowDTO(Cliente cliente);

}
