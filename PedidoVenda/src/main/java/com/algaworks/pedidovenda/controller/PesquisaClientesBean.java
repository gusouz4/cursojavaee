package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.repository.Clientes;
import com.algaworks.pedidovenda.repository.filter.ClienteFilter;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

public class PesquisaClientesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	Clientes clientes;

	private ClienteFilter filtro;
	private List<Cliente> clientesFiltrados;

	private Cliente clienteSelecionado;

	public PesquisaClientesBean() {
		filtro = new ClienteFilter();
	}

	public void excluir() {
		clientes.remover(clienteSelecionado);
		clientesFiltrados.remove(clienteSelecionado);

		FacesUtil.addInfoMessage("Cliente " + clienteSelecionado.getNome() + " excluído com sucesso.");
	}

	public void pesquisar() {
		clientesFiltrados = clientes.filtrados(filtro);
	}

	public ClienteFilter getFiltro() {
		return filtro;
	}

	public List<Cliente> getClientesFiltrados() {
		return clientesFiltrados;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

}