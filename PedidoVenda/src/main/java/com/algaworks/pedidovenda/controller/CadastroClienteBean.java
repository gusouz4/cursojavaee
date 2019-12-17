package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.Endereco;
import com.algaworks.pedidovenda.repository.Clientes;
import com.algaworks.pedidovenda.service.CadastroClienteService;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Clientes clientes;

	@Inject
	private CadastroClienteService cadastroClienteService;

	private Cliente cliente;

	private Endereco endereco;

	public CadastroClienteBean() {
		limpar();
		this.endereco = new Endereco();
	}

	public void limpar() {
		cliente = new Cliente();
		endereco = new Endereco();
	}

	public void salvar() {
		if(this.cliente.getEnderecos() == null) {
			this.cliente.setEnderecos(new ArrayList<Endereco>());
		}
		this.endereco.setCliente(cliente);
		
		this.cliente.getEnderecos().add(this.endereco);
		
		this.cliente = cadastroClienteService.salvar(this.cliente);
		limpar();

		FacesUtil.addInfoMessage("Cliente salvo com sucesso!");
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public CadastroClienteService getCadastroClienteService() {
		return cadastroClienteService;
	}

	public void setCadastroClienteService(CadastroClienteService cadastroClienteService) {
		this.cadastroClienteService = cadastroClienteService;
	}

	public Cliente getCliente() {
		if(Objects.nonNull(cliente) && !cliente.getEnderecos().isEmpty()) {
			this.endereco = cliente.getEnderecos().get(0);
		}
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public boolean isEditando() {
		return this.cliente.getId() != null;
	}

}
