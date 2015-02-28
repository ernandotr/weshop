package com.weshop.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.weshop.dao.EnderecoDAO;
import com.weshop.model.Endereco;

@Stateless
public class EnderecoFacade {

	@EJB
	private EnderecoDAO enderecoDAO;
	
	public void inserir(Endereco endereco){
		enderecoDAO.save(endereco);
	}
	
	public void update(Endereco endereco){
		enderecoDAO.updade(endereco);
	}
	
	public void delete(Long id){
		enderecoDAO.delete(id);
	}
	
	public Endereco findById(Long id){
		return enderecoDAO.find(id);
	}
}
