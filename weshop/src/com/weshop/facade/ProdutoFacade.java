package com.weshop.facade;

import javax.ejb.EJB;

import com.weshop.dao.ProdutoDAO;
import com.weshop.model.Produto;

public class ProdutoFacade {

	@EJB
	private ProdutoDAO produtoDAO;
	
	public void inserir(Produto produto){
		produtoDAO.save(produto);
	}
	
	public void update(Produto produto) {
		produtoDAO.updade(produto);
	}
	
	public void delete(Long id){
		produtoDAO.delete(id);
	}
	
	public Produto findById(Long id){
		return produtoDAO.find(id);
	}
}
