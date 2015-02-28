package com.weshop.teste;

import java.util.Date;

import javax.ejb.EJB;

import com.weshop.dao.UsuarioDAO;
import com.weshop.model.Usuario;

public class UsuarioTeste {

	@EJB
	private UsuarioDAO usuarioDAO;
	
	private Usuario usuario;
	
	public void novo(){
		this.usuario = new Usuario();
		usuario.setCpf("06182995645");
		usuario.setDataNascimento(new Date(1983,8,03));
		usuario.setEmail("ernando.03@gmail.com");
		usuario.setNome("Ernando Rezende");
		usuario.setSenha("asdf");
		usuarioDAO.save(usuario);
	}

	public static void main(String[] args) {
		UsuarioTeste teste = new UsuarioTeste();
		teste.novo();
	}
	
	public Usuario getUsuario() {
		if(usuario == null){
			usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
