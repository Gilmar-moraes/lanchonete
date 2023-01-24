package com.teste.finch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.finch.repository.PedidoRepository;
import com.teste.finch.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	
	@Autowired
	private PedidoService pedidoService;
}
