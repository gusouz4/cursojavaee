package com.algaworks.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.pedidovenda.model.Categoria;
import com.algaworks.pedidovenda.repository.Categorias;
import com.algaworks.pedidovenda.util.jpa.Transactional;

public class CadastroCategoriaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	Categorias categorias;
	
	@Transactional
	public Categoria salvar(Categoria categoria) {
		Categoria categoriaExistente = categorias.porDescricao(categoria.getDescricao());
		
		if (categoriaExistente != null && !categoriaExistente.equals(categoria)) {
			throw new NegocioException("Já existe uma categoria com a descrição informada.");
		}
		
		return categorias.guardar(categoria);
	}
}
