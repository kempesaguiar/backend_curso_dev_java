package br.com.kca.api.dto;

import java.io.Serializable;

import br.com.kca.api.models.Filme;

public class FilmShowDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String genero;
	private String status;
	
	public FilmShowDTO() {
		
	}
	
	public FilmShowDTO(Filme filme) {
		this.id = filme.getId();
		this.nome = filme.getNome();
		this.genero = filme.getGenero();
		this.status = filme.getStatus();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	

}
