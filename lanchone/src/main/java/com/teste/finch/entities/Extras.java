package com.teste.finch.entities;

import java.util.Objects;

import com.teste.finch.entities.enums.Ingredientes;

public class Extras {

	private Ingredientes ingrediente;
    private Integer qtd;
    
    public Extras() {
		// TODO Auto-generated constructor stub
	}

	public Extras(Ingredientes ingrediente, Integer qtd) {
		super();
		this.ingrediente = ingrediente;
		this.qtd = qtd;
	}

	public Ingredientes getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingredientes ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ingrediente, qtd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Extras other = (Extras) obj;
		return ingrediente == other.ingrediente && Objects.equals(qtd, other.qtd);
	}
}
