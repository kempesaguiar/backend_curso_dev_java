package br.com.kca.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kca.api.dto.LocacaoCreateDTO;
import br.com.kca.api.dto.ResponseLocacaoDTO;
import br.com.kca.api.exception.ClienteNotFoundException;
import br.com.kca.api.exception.FilmeNotFoundException;
import br.com.kca.api.services.LocacaoService;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {
	
	private LocacaoService locacaoService;
	
	@Autowired
	public LocacaoController(LocacaoService locacaoService) {
		this.locacaoService = locacaoService;
	}
	
	@GetMapping
	public ResponseEntity<List<ResponseLocacaoDTO>> listar() {
		List<ResponseLocacaoDTO> locacao = locacaoService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(locacao);
	}
	
	@PostMapping
	public ResponseEntity<ResponseLocacaoDTO> createLocacao(@RequestBody LocacaoCreateDTO locacaoCreateDTO) throws ClienteNotFoundException, FilmeNotFoundException {
		ResponseLocacaoDTO locacao = locacaoService.createLocacao(locacaoCreateDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(locacao);
	}
 
}
