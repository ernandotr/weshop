package com.weshop.dao;

import javax.ejb.Stateless;

import com.weshop.model.Produto;

@Stateless
public class ProdutoDAO extends GenericDAO<Produto>{
	
	public ProdutoDAO(){
		super(Produto.class);
	}
	
	public void delete(Long id){
		delete(id, Produto.class);
	}
}
