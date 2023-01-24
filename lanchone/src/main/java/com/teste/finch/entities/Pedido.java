package com.teste.finch.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.teste.finch.entities.enums.TiposLanches;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * import lombok.AllArgsConstructor;
 * import lombok.EqualsAndHashCode;
 * import lombok.Getter;
 * import lombok.NoArgsConstructor;
 * import lombok.Setter;
*/
@Entity
@Table(name = "pedido")
/*
 * @Getter
 * @Setter
 * @NoArgsConstructor
 * @AllArgsConstructor
 * @EqualsAndHashCode
 * OBS INVESTIGAR PQ O LOMBOK NÃO ESTA 
 * FUNCIONANDO ISSO PODE COMPROMETER
 * A CONTRATAÇÃO E PROJETOS FUTUROS
*/
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String endereco;
	private String nomeCliente;

	private TiposLanches lanche;
	
	private List<Extras> addIngredientes;
	
	private double total;

	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	
	public Pedido(Long id, String endereco, String nomeCliente, TiposLanches lanche, List<Extras> addIngredientes,
			double total) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.nomeCliente = nomeCliente;
		this.lanche = lanche;
		this.addIngredientes = addIngredientes;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public TiposLanches getLanche() {
		return lanche;
	}

	public void setLanche(TiposLanches lanche) {
		this.lanche = lanche;
	}

	public List<Extras> getAddIngredientes() {
		return addIngredientes;
	}

	public void setAddIngredientes(List<Extras> addIngredientes) {
		this.addIngredientes = addIngredientes;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nomeCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id) && Objects.equals(nomeCliente, other.nomeCliente);
	}
}
