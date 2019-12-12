package com.algaworks.pedidovenda.repository.filter;

import java.io.Serializable;

import com.algaworks.pedidovenda.validation.CPF;

public class ClienteFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long cpf;
	private String nome;
	private String email;

	@CPF
	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}