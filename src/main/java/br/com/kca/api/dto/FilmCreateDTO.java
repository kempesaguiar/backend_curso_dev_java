package br.com.kca.api.dto;

import java.io.Serializable;

public class FilmCreateDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String genero;
	
	public FilmCreateDTO() {
		
	}
	
	public FilmCreateDTO(String nome, String genero) {
		this.nome = nome;
		this.genero = genero;
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
