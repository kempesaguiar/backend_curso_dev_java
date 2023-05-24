package br.com.kca.api.services;

import java.util.List;

import br.com.kca.api.dto.FilmCreateDTO;
import br.com.kca.api.dto.FilmShowDTO;
import br.com.kca.api.exception.FilmeNotFoundException;

public interface FilmeService {
	
	// Lista todos os filmes
	List<FilmShowDTO> listar();
	
	//Criar Filme
	FilmShowDTO createFilme(FilmCreateDTO filmCreateDTO);
	
	// Lista filme por ID
	FilmShowDTO listaFilmeUnico(Long id) throws FilmeNotFoundException;
	
	// Atualiza filme por ID
	FilmShowDTO atualizarFilme(Long id, FilmCreateDTO filmCreateDTO) throws FilmeNotFoundException;
	
	// Exclui filme por id
	void excluirFilme(Long id) throws FilmeNotFoundException;
	
	

}
