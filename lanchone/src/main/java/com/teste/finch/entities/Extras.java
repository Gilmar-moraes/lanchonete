package com.teste.finch.entities;

import java.util.Objects;

import com.teste.finch.entities.enums.Ingredientes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "extra")
public class Extras {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
