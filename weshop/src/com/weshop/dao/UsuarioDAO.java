package com.weshop.dao;

import java.util.List;

import javax.ejb.Stateless;

import com.weshop.model.Usuario;

@Stateless
public class UsuarioDAO extends GenericDAO<Usuario>{

	public UsuarioDAO(){
		super(Usuario.class);
	}
	
	public void delete(Long id){
		delete(id, Usuario.class);
	}
	
	public List<Usuario> getAll(){
		return findAll();
	}
}
