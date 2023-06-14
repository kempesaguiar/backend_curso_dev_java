package br.com.kca.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.kca.api.dto.LocacaoCreateDTO;


@Entity
@Table(name = "locacao")
public class Locacao {
	
	@Id
	@SequenceGenerator(name = "id", sequenceName = "locacao_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locacao_id")
	private long id;
	
	@ManyToOne(targetEntity = Cliente.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@OneToOne(targetEntity = Filme.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "filme_id")
	private Filme filme;
	
	@Column(nullable = false, length = 80)
	private String data;
	
	@Column(nullable = false, length = 60)
	private String valor;
	
	public Locacao() {
		
	}
	
	public Locacao(LocacaoCreateDTO locacaoCreateDTO) {
		this.cliente = locacaoCreateDTO.getCliente();
		this.filme = locacaoCreateDTO.getFilme();
		this.data = locacaoCreateDTO.getData();
		this.valor = locacaoCreateDTO.getValor();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	
	

}
