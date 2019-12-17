package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Categoria;
import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.Categorias;
import com.algaworks.pedidovenda.repository.filter.CategoriaFilter;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaCategoriasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	Categorias categorias;

	private CategoriaFilter filtro;
	private List<Categoria> categoriasFiltradas;

	private Categoria categoriaSelecionada;
	
	@Inject
	private Produto produto;

	public PesquisaCategoriasBean() {
		filtro = new CategoriaFilter();
	}

	public void excluir() {
		if(categoriaSelecionada.getCategoriaPai() == null || categoriaSelecionada.getId() == produto.getCategoria().getId()) {
			FacesUtil.addErrorMessage("Categoria " + categoriaSelecionada.getDescricao() + " não pode ser excluída.");
		}
		else {
			categorias.remover(categoriaSelecionada);
			categoriasFiltradas.remove(categoriaSelecionada);

			FacesUtil.addInfoMessage("Categoria " + categoriaSelecionada.getDescricao() + " excluída com sucesso.");
		}
	}

	public void pesquisar() {
		categoriasFiltradas = categorias.filtrados(filtro);
	}

	public List<Categoria> getCategoriasFiltradas() {
		return categoriasFiltradas;
	}

	public Categoria getCategoriaSelecionada() {
		return categoriaSelecionada;
	}

	public void setCategoriaSelecionada(Categoria categoriaSelecionada) {
		this.categoriaSelecionada = categoriaSelecionada;
	}

	public CategoriaFilter getFiltro() {
		return filtro;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	

}