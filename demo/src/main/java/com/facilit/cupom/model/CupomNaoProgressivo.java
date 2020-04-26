package com.facilit.cupom.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class CupomNaoProgressivo extends Cupom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer quantidadeprodutos;
	
	public CupomNaoProgressivo() {
		
	}
	public CupomNaoProgressivo(Long id, String nome, Float desconto) {
		super(id, nome, desconto);
		// TODO Auto-generated constructor stub
	}
	
	public CupomNaoProgressivo(Long id, String nome, Float desconto, Integer quantidadeprodutos ) {
		
		this(id, nome, desconto);
		this.quantidadeprodutos = quantidadeprodutos;
		// TODO Auto-generated constructor stub
	}

	public Integer getQuantidadeprodutos() {
		return quantidadeprodutos;
	}

	public void setQuantidadeprodutos(Integer quantidadeprodutos) {
		this.quantidadeprodutos = quantidadeprodutos;
	}

	
	
}
