package com.weshop.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.weshop.dao.UsuarioDAO;
import com.weshop.model.Usuario;

@Stateless
public class UsuarioFacade {

	@EJB
	private UsuarioDAO usuarioDAO;
	
	public void inserir(Usuario usuario) {
		usuarioDAO.save(usuario);
	}
	
	public void update(Usuario usuario){
		usuarioDAO.updade(usuario);
	}
	
	public void delete(Long id){
		delete(id);
	}
	
	public List<Usuario> listarUsuarios(){
		return usuarioDAO.getAll();
	}
	
	public Usuario fingById(String id){
		return fingById(id);
	}
}
