package br.com.kca.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kca.api.dto.FilmCreateDTO;
import br.com.kca.api.dto.FilmShowDTO;
import br.com.kca.api.exception.FilmeNotFoundException;
import br.com.kca.api.mapper.MapStructFilmeMapper;
import br.com.kca.api.models.Filme;
import br.com.kca.api.repositories.FilmeRepository;

@Service
public class FilmeServiceImpl implements FilmeService {
	
	private FilmeRepository filmeRepository;
	private MapStructFilmeMapper filmeMapper;
	
	@Autowired
	public FilmeServiceImpl(FilmeRepository filmeRepository, MapStructFilmeMapper filmeMapper) {
		this.filmeRepository = filmeRepository;
		this.filmeMapper = filmeMapper;
	}
	

	@Override
	public List<FilmShowDTO> listar() {
		return this.filmeRepository.findAll()
				.stream().map(filme -> this.filmeMapper.toDTO(filme))
				.collect(Collectors.toList());
	}

	@Override
	public FilmShowDTO createFilme(FilmCreateDTO filmCreateDTO) {
		Filme salva = filmeMapper.toModel(filmCreateDTO);
		Filme filme = filmeRepository.save(salva);
		return filmeMapper.toDTO(filme);
	}

	@Override
	public FilmShowDTO listarFilmeUnico(Long id) throws FilmeNotFoundException {
		Filme filme = filmeRepository.findById(id)
				.orElseThrow(() -> new FilmeNotFoundException(id));
		return filmeMapper.toDTO(filme);
	}

	@Override
	public FilmShowDTO atualizarFilme(Long id, FilmCreateDTO filmCreateDTO) throws FilmeNotFoundException {
		Filme atualiza = filmeMapper.toModel(filmCreateDTO);
		Filme filme = filmeRepository.findById(id)
				.orElseThrow(() -> new FilmeNotFoundException(id));
		atualiza.setId(id);
		filmeRepository.save(atualiza);
		return filmeMapper.toDTO(atualiza);
	}

	@Override
	public void excluirFilme(Long id) throws FilmeNotFoundException {
		Filme filme = filmeRepository.findById(id)
				.orElseThrow(() -> new FilmeNotFoundException(id));
		filmeRepository.deleteById(id);
		
	}

}
