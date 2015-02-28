package com.weshop.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.weshop.facade.EnderecoFacade;
import com.weshop.facade.UsuarioFacade;
import com.weshop.model.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioMB {

	@EJB
	private UsuarioFacade facade;
	@EJB
	private EnderecoFacade endFacade;
	
	private List<Usuario> listaUsuario;
	
	@PostConstruct
	public void listar(){
		listaUsuario = new ArrayList<Usuario>();
		listaUsuario = facade.listarUsuarios();
	}
	
	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	private Usuario usuario;

	public Usuario getUsuario() {
		if(usuario == null){
			usuario= new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void login(){
		
	}
	
	public void salvar(){
		if(usuario != null && usuario.getEmail() != null){
			endFacade.inserir(usuario.getEndereco());
			System.out.println("Endereço do usuário gravado!");
			facade.inserir(usuario);
			System.out.println("Usuário gravado com sucesso!");
		}else{
			System.out.println("Usuário não é valido!");
		}
		usuario = new Usuario();
		
		listar();
	}
}
