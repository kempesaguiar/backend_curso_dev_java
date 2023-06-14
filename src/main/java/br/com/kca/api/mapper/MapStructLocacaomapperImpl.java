package br.com.kca.api.mapper;

import org.springframework.stereotype.Component;

import br.com.kca.api.dto.LocacaoCreateDTO;
import br.com.kca.api.dto.ResponseLocacaoDTO;
import br.com.kca.api.models.Locacao;

@Component
public class MapStructLocacaomapperImpl implements MapStructLocacaoMapper {

	@Override
	public ResponseLocacaoDTO toDTO(Locacao locacao) {
		return new ResponseLocacaoDTO(locacao);
	}

	@Override
	public Locacao toModel(LocacaoCreateDTO locacaoCreateDTO) {
		return new Locacao(locacaoCreateDTO);
	}
	
	

}
