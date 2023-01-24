package com.teste.finch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.teste.finch.entities.Pedido;
import com.teste.finch.repository.PedidoRepository;
import com.teste.finch.service.PedidoService;

/**
 * @author Gilmar Junior
 */
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	
	@Autowired
	private PedidoService pedidoService;
	private PedidoRepository pedidoRepository;
	
	/**
	 * Metodo de pesquisa
	 * @return lista de todos os pedidos
	 */
	@GetMapping
	public List<Pedido> listPedidos(){
		return pedidoService.findAll();
	}
	
	/**
	 * Pesquisa de id especifico
	 * @param id
	 * @return um pedido de id especifico
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> listPedidoId(@PathVariable Long id){
		return pedidoRepository.findById(id)
				.map(pedido -> ResponseEntity.ok(pedido))
				.orElse(ResponseEntity.notFound().build());
	}
	
	/**
	 * Metodo para criar/inserir um novo pedido
	 * @param pedido
	 * @return retona o status de criação
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pedido criarPedido(@RequestBody Pedido pedido) {
		return pedidoService.save(pedido);
	}
	
	/**
	 * Metodo responsavel por fazer a exclusão dos pedidos
	 * @param id
	 * @return
	 */
	@DeleteMapping
	public ResponseEntity<Void> excluirPedido(@PathVariable Long id){
		if (!pedidoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		pedidoService.excluir(id);
		return ResponseEntity.noContent().build();
	}
}

