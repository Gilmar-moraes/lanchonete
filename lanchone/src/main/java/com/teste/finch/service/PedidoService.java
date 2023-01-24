package com.teste.finch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teste.finch.entities.Extras;
import com.teste.finch.entities.Pedido;
import com.teste.finch.entities.enums.Ingredientes;
import com.teste.finch.entities.enums.TiposLanches;
import com.teste.finch.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Transactional(readOnly = true)
	public List<Pedido> findAll(){
		return this.pedidoRepository.findAll();
	}
	
	@Transactional
	public Pedido save(Pedido pedido) {
		this.valorTotal(pedido);
		return this.pedidoRepository.save(pedido);
	}
	
	@Transactional
	public void excluir(Long pedidoId) {
		pedidoRepository.deleteById(pedidoId);
	}
	
	public Pedido valorTotal(Pedido pedidos) {
		Pedido pedido = new Pedido();
		boolean isAdcional = false;
		Double total = 0.0;
		
		List<Ingredientes>ingredientes = new ArrayList<>();
		
		if (pedido.getLanche() != null) {
			ingredientes.addAll(TiposLanches.lanches(pedido.getLanche()));
			if (pedido.getAddIngredientes() != null && !pedido.getAddIngredientes().isEmpty()) {
				isAdcional = true;
				for (Extras ingredientesExtra : pedido.getAddIngredientes()) {
					for (int cont = 0; cont < ingredientesExtra.getQtd(); cont++) {
						ingredientes.add(ingredientesExtra.getIngrediente());
					}
				}
				for (Ingredientes tipoIngredientes : ingredientes) {
					total = total + Ingredientes.ingrediente(tipoIngredientes);
				}
				if (isAdcional == true) {
					total = this.promocaoLight(ingredientes, total);
					
					total = this.promocaoMuitaCarne(ingredientes, total);
					
					total = this.promocaoMuitaQueijo(ingredientes, total);
				}
			}
		}
		return pedidos;
	}
	
	public Double promocaoLight(List<Ingredientes> ingredientes, Double valor) {
		Double desconto = 0.0;
		for (Ingredientes ingredientes2 : ingredientes) {
			if (ingredientes2 == Ingredientes.ALFACE && ingredientes2 != Ingredientes.BACON) {
				desconto = valor*0.1;
			}
		}
		return valor-desconto;
	}
	
	public Double promocaoMuitaCarne(List<Ingredientes> ingredientes, Double valor) {
		Double desconto = 0.0;
		int qtdCarne = 0;
		for (Ingredientes ingredientes2 : ingredientes) {
			if (ingredientes2 == Ingredientes.HAMBURGUER) {
				qtdCarne++;
			}
			desconto = valor * ((qtdCarne-2)/100);
		}
		return valor-desconto;
	}
	
	public Double promocaoMuitaQueijo(List<Ingredientes> ingredientes, Double valor) {
		Double desconto = 0.0;
		int qtdQueijo = 0;
		for (Ingredientes ingredientes2 : ingredientes) {
			if (ingredientes2 == Ingredientes.HAMBURGUER) {
				qtdQueijo++;
			}
			desconto = valor * ((qtdQueijo-2)/100);
		}
		return valor-desconto;
	}
}
