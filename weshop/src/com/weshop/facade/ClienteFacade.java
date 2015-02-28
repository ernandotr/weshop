package com.weshop.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.weshop.dao.ClienteDAO;
import com.weshop.model.Cliente;

@Stateless
public class ClienteFacade {

	@EJB
	private ClienteDAO clienteDAO;
	
	public List<Cliente> getClientes(){
		return clienteDAO.findAll();
	}
	
	public void inserir(Cliente cliente){
		clienteDAO.save(cliente);
	}
	
	public void update(Cliente cliente){
		clienteDAO.updade(cliente);
	}
	
	public void delete(Long id){
		clienteDAO.delete(id);
	}
	
	public Cliente findById(Long id){
		return clienteDAO.find(id);
	}
	
	
}
