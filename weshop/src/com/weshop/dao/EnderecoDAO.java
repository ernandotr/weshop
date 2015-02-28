package com.weshop.dao;

import javax.ejb.Stateless;

import com.weshop.model.Endereco;

@Stateless
public class EnderecoDAO extends GenericDAO<Endereco>{

	public EnderecoDAO(){
		super(Endereco.class);
	}
	public void delete(Long id){
		delete(id, Endereco.class);
	}
}
