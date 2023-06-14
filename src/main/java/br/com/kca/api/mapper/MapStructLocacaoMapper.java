package br.com.kca.api.mapper;

import org.mapstruct.Mapper;

import br.com.kca.api.dto.LocacaoCreateDTO;
import br.com.kca.api.dto.ResponseLocacaoDTO;
import br.com.kca.api.models.Locacao;

@Mapper(componentModel = "spring")
public interface MapStructLocacaoMapper {
	
	ResponseLocacaoDTO toDTO(Locacao locacao);
	
	Locacao toModel(LocacaoCreateDTO locacaoCreateDTO);

}
