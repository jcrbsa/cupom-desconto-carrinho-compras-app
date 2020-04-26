package com.facilit.cupom.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Carrinho implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToMany
	@JoinTable(name = "carrinho_tem_produto", joinColumns = {
			@JoinColumn(name = "carrinho_id") }, inverseJoinColumns = { @JoinColumn(name = "produto_id") })
	private List<Produto> Produto;

	@ManyToMany
	@JoinTable(name = "carrinho_tem_cupom", joinColumns = { @JoinColumn(name = "carrinho_id") }, inverseJoinColumns = {
			@JoinColumn(name = "cupom_id") })
	private List<Cupom> Cupom;

	public Carrinho() {
		super();
		// TODO Auto-generated constructor stub
	}

	private float total;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Produto> getProduto() {
		return Produto;
	}

	public void setProduto(List<Produto> produto) {
		Produto = produto;
	}

	public List<Cupom> getCupom() {
		return Cupom;
	}

	public void setCupom(List<Cupom> cupom) {
		Cupom = cupom;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	

}
