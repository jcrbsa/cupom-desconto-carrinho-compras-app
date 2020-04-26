package com.facilit.cupom.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class CupomProgressivo extends Cupom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Float valorcompras;
	public CupomProgressivo() {
		
	}
	public CupomProgressivo(Long id, String nome, Float desconto) {
		super(id, nome, desconto);
		// TODO Auto-generated constructor stub
	}
	
	public CupomProgressivo(Long id, String nome, Float desconto, Float valorcompras ) {
		
		this(id, nome, desconto);
		this.valorcompras = valorcompras;
		// TODO Auto-generated constructor stub
	}

	public Float getValorcompras() {
		return valorcompras;
	}

	public void setValorcompras(Float valorcompras) {
		this.valorcompras = valorcompras;
	}
	
	
	
}
