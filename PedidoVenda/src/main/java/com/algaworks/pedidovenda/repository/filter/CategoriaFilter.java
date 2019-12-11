package com.algaworks.pedidovenda.repository.filter;

import java.io.Serializable;
import java.util.List;

import com.algaworks.pedidovenda.model.Categoria;

public class CategoriaFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descricao;
	private List<Categoria> categoria_pai;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Categoria> getCategoria_pai() {
		return categoria_pai;
	}

	public void setCategoria_pai(List<Categoria> categoria_pai) {
		this.categoria_pai = categoria_pai;
	}

}