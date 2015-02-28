package com.weshop.dao;

import javax.ejb.Stateless;

import com.weshop.model.Cliente;

@Stateless
public class ClienteDAO extends GenericDAO<Cliente>{

	public ClienteDAO() {
		super(Cliente.class);
		// TODO Auto-generated constructor stub
	}
	
	public void delete(long id){
		delete(id, Cliente.class);
	}
}
