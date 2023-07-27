package br.com.kca.api.services;

import java.util.List;

import br.com.kca.api.dto.FilmCreateDTO;
import br.com.kca.api.dto.FilmShowDTO;
import br.com.kca.api.exception.FilmeNotFoundException;

public interface FilmeService {
	
	// Lista todos os filmes
	List<FilmShowDTO> listar();
	
	// Lista filmes disponíveis
	List<FilmShowDTO> listarDisponiveis();
	
	// Criar filmes
	FilmShowDTO createFilme(FilmCreateDTO filmCreateDTO);
	
	// Listar filme por ID
	FilmShowDTO listarFilmeUnico(Long id) throws FilmeNotFoundException;
	
	// Atualiar Filme
	FilmShowDTO atualizarFilme(Long id, FilmCreateDTO filmCreateDTO) throws FilmeNotFoundException;
	
	// Deleta Filme
	void excluirFilme(Long id) throws FilmeNotFoundException;
	
	

}
