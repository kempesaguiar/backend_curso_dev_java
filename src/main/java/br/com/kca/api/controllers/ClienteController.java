package br.com.kca.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kca.api.dto.ClientCreateDTO;
import br.com.kca.api.dto.ClienteShowDTO;
import br.com.kca.api.exception.ClienteNotFoundException;
import br.com.kca.api.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping("/msg")
	public String listMsg() {
		return "Curso Dev Software";
	}
	
	//Endpoint Lista Todos clientes
	@GetMapping
	public ResponseEntity<List<ClienteShowDTO>> listar() {
		List<ClienteShowDTO> cliente = clienteService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}
	
	
	//Endpoint Criar Cliente
	@PostMapping
	public ResponseEntity<ClienteShowDTO> createCliente(@RequestBody ClientCreateDTO clientCreateDTO) {
		ClienteShowDTO response = clienteService.createCliente(clientCreateDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	
	//Endpoint Lista Cliente por ID
	@GetMapping("/{id}")
	public ResponseEntity<ClienteShowDTO> listaClienteUnico(@PathVariable Long id) throws ClienteNotFoundException {
		ClienteShowDTO response = clienteService.listaClienteUnico(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//Endpoint Atualiza Cliente
	@PutMapping("/{id}")
	public ResponseEntity<ClienteShowDTO> atualizaCliente(@PathVariable Long id, @RequestBody ClientCreateDTO clientCreateDTO) throws ClienteNotFoundException {
		ClienteShowDTO response = clienteService.atualizaCliente(id, clientCreateDTO);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	//Endpoint Deleta Cliente
	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluir(@PathVariable Long id) throws ClienteNotFoundException {
		clienteService.excluir(id);
		return ResponseEntity.status(HttpStatus.OK).body("Cliente " + id + " excluído com sucesso ");
		
	}
}
