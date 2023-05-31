package br.com.kca.api.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.kca.api.dto.FilmCreateDTO;

@Entity
@Table(name = "filmes")
public class Filme implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "filme_id", sequenceName = "filme_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable = false, length = 160)
	private String nome;
	
	@Column(nullable = false, length = 180)
	private String genero;
	
	public Filme() {
		
	}
	
	public Filme(FilmCreateDTO filmCreateDTO) {
		this.nome = filmCreateDTO.getNome();
		this.genero = filmCreateDTO.getGenero();
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
