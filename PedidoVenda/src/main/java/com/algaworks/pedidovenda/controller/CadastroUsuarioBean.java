package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.Endereco;
import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.repository.Clientes;
import com.algaworks.pedidovenda.repository.Usuarios;
import com.algaworks.pedidovenda.service.CadastroClienteService;
import com.algaworks.pedidovenda.service.CadastroUsuarioService;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;

	@Inject
	private CadastroUsuarioService cadastroUsuarioService;

	private Usuario usuario;

	public CadastroUsuarioBean() {
		limpar();
	}

	public void limpar() {
		usuario = new Usuario();
	}

	public void salvar() {
		this.usuario = cadastroUsuarioService.salvar(this.usuario);
		limpar();

		FacesUtil.addInfoMessage("Usuário salvo com sucesso!");
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public CadastroUsuarioService getCadastroUsuarioService() {
		return cadastroUsuarioService;
	}

	public void setCadastroUsuarioService(CadastroUsuarioService cadastroUsuarioService) {
		this.cadastroUsuarioService = cadastroUsuarioService;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isEditando() {
		return this.usuario.getId() != null;
	}

}
