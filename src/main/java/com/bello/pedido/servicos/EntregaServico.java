package com.bello.pedido.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bello.pedido.entidades.Entrega;
import com.bello.pedido.entidades.Pedido;
import com.bello.pedido.rabbitmq.EnviarFilaEntrega;
import com.bello.pedido.repositorios.EntregaRepositorio;

@Service
public class EntregaServico {
	
	@Autowired
	private EntregaRepositorio entregaRepositorio;
	
	@Autowired
	private EnviarFilaEntrega enviarFilaEntrega;
	
	public void insert(Entrega entrega) {
		entregaRepositorio.save(entrega);
	}
	
	public void gerarEntrega(Pedido pedido) {
		Entrega entrega = new Entrega();
		entrega.setId(pedido.getId());
		entrega.setEndereco(pedido.getEndereco());
							
		enviarFilaEntrega.send(entrega);		
	}
}