package br.com.kca.api.dto;

import java.io.Serializable;

import br.com.kca.api.models.Cliente;
import br.com.kca.api.models.Filme;

public class LocacaoCreateDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	private Filme filme;
	private String data;
	private String valor;
	
	public LocacaoCreateDTO() {
		
	}
	
	public LocacaoCreateDTO(String data, String valor) {
		this.data = data;
		this.valor = valor;
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
