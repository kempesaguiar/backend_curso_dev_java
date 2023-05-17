package br.com.kca.api.mapper;

import org.springframework.stereotype.Component;

import br.com.kca.api.dto.FilmCreateDTO;
import br.com.kca.api.dto.FilmShowDTO;
import br.com.kca.api.models.Filme;

@Component
public class MapStructFilmeMapperImpl implements MapStructFilmeMapper {

	@Override
	public FilmShowDTO toDTO(Filme filme) {
		return new FilmShowDTO(filme);
	}

	@Override
	public Filme toModel(FilmCreateDTO filmCreateDTO) {
		return new Filme(filmCreateDTO);
	}
}
