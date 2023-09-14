package br.com.kca.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kca.api.dto.LocacaoCreateDTO;
import br.com.kca.api.dto.ResponseLocacaoDTO;
import br.com.kca.api.exception.ClienteNotFoundException;
import br.com.kca.api.exception.FilmeNotFoundException;
import br.com.kca.api.mapper.MapStructLocacaoMapper;
import br.com.kca.api.models.Cliente;
import br.com.kca.api.models.Filme;
import br.com.kca.api.models.Locacao;
import br.com.kca.api.repositories.ClienteRepository;
import br.com.kca.api.repositories.FilmeRepository;
import br.com.kca.api.repositories.LocacaoRepository;

@Service
public class LocacaoServiceImpl implements LocacaoService {
	
	private LocacaoRepository locacaoRepository;
	private ClienteRepository clienteRepository;
	private FilmeRepository filmeRepository;
	private MapStructLocacaoMapper locacaoMapper;
	
	@Autowired
	public LocacaoServiceImpl(LocacaoRepository locacaoRepository, ClienteRepository clienteRepository, FilmeRepository filmeRepository, MapStructLocacaoMapper locacaoMapper) {
		this.locacaoRepository = locacaoRepository;
		this.clienteRepository = clienteRepository;
		this.filmeRepository = filmeRepository;
		this.locacaoMapper = locacaoMapper;
	}

	@Override
	public List<ResponseLocacaoDTO> listar() {
		return this.locacaoRepository.findAll()
				.stream().map(locacao -> this.locacaoMapper.toDTO(locacao))
				.collect(Collectors.toList());
	}

	@Override
	public ResponseLocacaoDTO createLocacao(LocacaoCreateDTO locacaoCreateDTO)
			throws FilmeNotFoundException, ClienteNotFoundException {
		// Busca id do cliente que veio no Request
		Long cliente_id = locacaoCreateDTO.getCliente().getId();
		// Busca id do Filme que veio no Request
		Long filme_id = locacaoCreateDTO.getFilme().getId();
		// Busca cliente por ID
		Cliente cliente = clienteRepository.findById(cliente_id)
				.orElseThrow(() -> new ClienteNotFoundException(cliente_id));
		// Busca filme por ID
		Filme filme = filmeRepository.findById(filme_id)
				.orElseThrow(() -> new FilmeNotFoundException(filme_id));
		Locacao locacao = locacaoMapper.toModel(locacaoCreateDTO);
		locacao.setCliente(cliente);
		filme.setStatus("Alugado");
		locacao.setStatus("alugado");
		locacao.setFilme(filme);
		Locacao response = locacaoRepository.save(locacao);
		return locacaoMapper.toDTO(response);
	}

	@Override
	public ResponseLocacaoDTO devolveLocacao(Long id) throws FilmeNotFoundException {
		Locacao locacao = locacaoRepository.findById(id)
				.orElseThrow(() -> new FilmeNotFoundException(id));
		Long filme_id = locacao.getFilme().getId();
	
		Filme filme = filmeRepository.findById(filme_id)
				.orElseThrow(() -> new FilmeNotFoundException(filme_id));
		filme.setStatus("Disponível");
		filme.setId(filme_id);
		filmeRepository.save(filme);
		locacao.setStatus("devolvido");
		locacaoRepository.save(locacao);
		return locacaoMapper.toDTO(locacao);
		
	}

}
