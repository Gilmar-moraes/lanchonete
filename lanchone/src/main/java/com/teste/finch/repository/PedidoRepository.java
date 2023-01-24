package com.teste.finch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.finch.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	 List<Pedido> findAll();
}
