package br.com.kca.api.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kca.api.dto.ClientCreateDTO;
import br.com.kca.api.dto.ClienteShowDTO;
import br.com.kca.api.dto.LoginDTO;
import br.com.kca.api.exception.ClienteNotFoundException;
import br.com.kca.api.mapper.MapStructClienteMapper;
import br.com.kca.api.models.Cliente;
import br.com.kca.api.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private ClienteRepository clienteRepository;
	private MapStructClienteMapper mapper;
	
	@Autowired
	public ClienteServiceImpl(ClienteRepository clienteRepository, 
			MapStructClienteMapper mapper) {
		this.clienteRepository = clienteRepository;
		this.mapper = mapper;
	}

	@Override
	public List<ClienteShowDTO> listar() {
		return this.clienteRepository.findAll()
				.stream().map(cliente -> 
				this.mapper.clienteToClienteShowDTO(cliente))
				.collect(Collectors.toList());
				
	}

	@Override
	public ClienteShowDTO createCliente(ClientCreateDTO clientCreateDTO) {
		Cliente novocliente = mapper.toModel(clientCreateDTO);
		Cliente response = clienteRepository.save(novocliente);
		return mapper.clienteToClienteShowDTO(response);
	}

	@Override
	public ClienteShowDTO listaClienteUnico(Long id) throws ClienteNotFoundException {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ClienteNotFoundException(id));
		return mapper.clienteToClienteShowDTO(cliente);
	}

	@Override
	public ClienteShowDTO atualizaCliente(Long id, ClientCreateDTO clientCreateDTO) throws ClienteNotFoundException {
		Cliente atualizaCliente = mapper.toModel(clientCreateDTO);
		Cliente buscacliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ClienteNotFoundException(id));
		atualizaCliente.setId(id);
		Cliente response = clienteRepository.save(atualizaCliente);
		return mapper.clienteToClienteShowDTO(atualizaCliente);
	}

	@Override
	public void excluir(Long id) throws ClienteNotFoundException {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ClienteNotFoundException(id));
		clienteRepository.deleteById(id);
		
	}

	@Override
	public ClienteShowDTO login(LoginDTO loginDTO) throws ClienteNotFoundException {
		Long id = clienteRepository.findByLogin(loginDTO.getEmail(), loginDTO.getTelefone());
		Cliente buscaCliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ClienteNotFoundException(id));
		return mapper.clienteToClienteShowDTO(buscaCliente);
	}
	
	
	

}
