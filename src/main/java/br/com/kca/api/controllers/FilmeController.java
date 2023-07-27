package br.com.kca.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kca.api.dto.FilmCreateDTO;
import br.com.kca.api.dto.FilmShowDTO;
import br.com.kca.api.exception.FilmeNotFoundException;
import br.com.kca.api.services.FilmeService;

@CrossOrigin
@RestController
@RequestMapping("/filmes")
public class FilmeController {
	
	private FilmeService filmeService;
	
	@Autowired
	public FilmeController(FilmeService filmeService) {
		this.filmeService = filmeService;
	}
	
	@GetMapping
	public ResponseEntity<List<FilmShowDTO>> listar() {
		List<FilmShowDTO> filmes = filmeService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(filmes);
	}
	
	@PostMapping
	public ResponseEntity<FilmShowDTO> createFilme(@RequestBody FilmCreateDTO filmCreateDTO) {
		FilmShowDTO response = filmeService.createFilme(filmCreateDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FilmShowDTO> listaFilmeUnico(@PathVariable Long id) throws FilmeNotFoundException {
		FilmShowDTO response = filmeService.listarFilmeUnico(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FilmShowDTO> atualizaFilme(@PathVariable Long id, @RequestBody FilmCreateDTO filmCreateDTO) throws FilmeNotFoundException {
		FilmShowDTO response = filmeService.atualizarFilme(id, filmCreateDTO);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> excluir(@PathVariable Long id) throws FilmeNotFoundException {
		filmeService.excluirFilme(id);
		return ResponseEntity.status(HttpStatus.OK).body("Filme " + id + " excluído com sucesso");
	}
	
	@GetMapping("/disponiveis")
	public ResponseEntity<List<FilmShowDTO>> listarDisponiveis() {
		List<FilmShowDTO> filmes = filmeService.listarDisponiveis();
		return ResponseEntity.status(HttpStatus.OK).body(filmes);
	}

}
