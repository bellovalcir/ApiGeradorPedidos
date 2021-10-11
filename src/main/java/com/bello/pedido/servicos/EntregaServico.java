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
	
	public void enviarFilaEntrega(String filaEntrega) {
		enviarFilaEntrega.send(filaEntrega);
	}
	
	public void insert(Entrega entrega) {
		entregaRepositorio.save(entrega);
	}
	
	public void gerarEntrega(Pedido pedido) {
		Entrega entrega = new Entrega();
		entrega.setEndereco(pedido.getEndereco());
		entregaRepositorio.save(entrega);
					
		String filaEntrega = "Pedido: " + pedido.getId() + " Endereço entrega: " + pedido.getEndereco();
		enviarFilaEntrega.send(filaEntrega);		
	}
}
