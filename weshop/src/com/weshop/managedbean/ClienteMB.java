package com.weshop.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.weshop.facade.ClienteFacade;
import com.weshop.facade.EnderecoFacade;
import com.weshop.model.Cliente;

@ManagedBean
@ViewScoped
public class ClienteMB {

	@EJB
	private ClienteFacade clienteFacade;
	@EJB
	private EnderecoFacade endFacade; 
	
	private Cliente cliente;
	private List<Cliente> listaCliente;
	
	@PostConstruct
	public void listar(){
		listaCliente = clienteFacade.getClientes();
	}
	
	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public Cliente getCliente() {
		if(cliente == null){
			cliente = new Cliente();
		}
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void salvar(){
		if(cliente != null && cliente.getEndereco() != null){
			endFacade.inserir(cliente.getEndereco());
			System.out.println("Endereço do Cliente gravado");
			clienteFacade.inserir(cliente);
			System.out.println("Cliente Gravado com sucesso!");
		}
	}
	public void novo(){
		
	}
}
