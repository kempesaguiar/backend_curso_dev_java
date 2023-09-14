package br.com.kca.api.dto;

import java.io.Serializable;

import br.com.kca.api.models.Cliente;
import br.com.kca.api.models.Filme;
import br.com.kca.api.models.Locacao;

public class ResponseLocacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Cliente cliente;
	private Filme filme;
	private String data;
	private String valor;
	private String status;
	
	
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public ResponseLocacaoDTO() {
		
	}

	
	public ResponseLocacaoDTO(Locacao locacao) {
		this.id = locacao.getId();
		this.cliente = locacao.getCliente();
		this.filme = locacao.getFilme();
		this.data = locacao.getData();
		this.valor = locacao.getValor();
		this.status = locacao.getStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
