package com.weshop.model;

import java.awt.Image;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	private String descricao;
	
	private Double valorNormal;
	
	private Double valorDesconto;
	
	private Double desconto;
	
	
	@Column(name="data_cadastro")
	private Date dataCadastro;
	
	@Column(name="data_alteracao")
	private Date dataAlteracao;
	
	@OneToOne
	@JoinColumn(name="usuario_cadastro")
	private Usuario usuarioCadastro;
	
	@OneToOne
	@JoinColumn(name="usuario_alteracao")
	private Usuario usuarioAlteracao;
	
	@Transient
	private Image fotoProduto;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorNormal() {
		return valorNormal;
	}

	public void setValorNormal(Double valorNormal) {
		this.valorNormal = valorNormal;
	}

	public Double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(Double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Usuario getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(Usuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public Usuario getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Usuario usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

	public Image getFotoProduto() {
		return fotoProduto;
	}

	public void setFotoProduto(Image fotoProduto) {
		this.fotoProduto = fotoProduto;
	}
}
