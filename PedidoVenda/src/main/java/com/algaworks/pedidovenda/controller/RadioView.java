package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.TipoPessoa;

@Named
@ViewScoped
public class RadioView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private TipoPessoa tipoPessoa;
	private List<TipoPessoa> tipos;

	public void carregarTipos() {
		   this.tipos = Arrays.asList(TipoPessoa.values());
		}
	
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public List<TipoPessoa> getTipos() {
		return tipos;
	}

	public void setTipos(List<TipoPessoa> tipos) {
		this.tipos = tipos;
	}
	
}
