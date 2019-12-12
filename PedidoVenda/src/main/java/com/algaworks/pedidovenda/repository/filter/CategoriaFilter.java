package com.algaworks.pedidovenda.repository.filter;

import java.io.Serializable;
import java.util.List;

import com.algaworks.pedidovenda.model.Categoria;

public class CategoriaFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descricao;
	private List<Categoria> categoriaPai;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Categoria> getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(List<Categoria> categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

}