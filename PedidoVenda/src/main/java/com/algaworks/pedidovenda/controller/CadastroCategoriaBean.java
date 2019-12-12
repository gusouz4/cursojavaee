package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Categoria;
import com.algaworks.pedidovenda.repository.Categorias;
import com.algaworks.pedidovenda.service.CadastroCategoriaService;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroCategoriaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	Categorias categorias;

	@Inject
	CadastroCategoriaService cadastroCategoriaService;

	private Categoria categoria;
	private List<Categoria> categoriasRaizes;

	private void limpar() {
		categoria = new Categoria();
	}

	/*
	 * public CadastroCategoriaBean() { limpar(); }
	 */

	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			categoriasRaizes = categorias.raizes();
		}
	}

	public void salvar() {
		this.categoria = cadastroCategoriaService.salvar(this.categoria);
		limpar();

		if (categoriasRaizes != null) {
			FacesUtil.addInfoMessage("Subcategoria salva com sucesso!");
		} else {
			FacesUtil.addInfoMessage("Categoria salva com sucesso!");
		}
	}

	public Categorias getCategorias() {
		return categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}

	public void setCategoriasRaizes(List<Categoria> categoriasRaizes) {
		this.categoriasRaizes = categoriasRaizes;
	}
	
	public boolean isEditando() {
		return this.categoria != null && this.categoria.getId() != null; 
	}

}