package br.com.kca.api.mapper;

import org.mapstruct.Mapper;

import br.com.kca.api.dto.FilmCreateDTO;
import br.com.kca.api.dto.FilmShowDTO;
import br.com.kca.api.models.Filme;

@Mapper(componentModel = "spring")
public interface MapStructFilmeMapper {
	
	FilmShowDTO toDTO(Filme filme);
	
	Filme toModel(FilmCreateDTO filmCreateDTO);

}
