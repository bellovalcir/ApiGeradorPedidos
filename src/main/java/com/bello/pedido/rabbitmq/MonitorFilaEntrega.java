package com.bello.pedido.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.bello.pedido.entidades.Entrega;
import com.bello.pedido.servicos.EntregaServico;

@Component
public class MonitorFilaEntrega {
	
	@Autowired
	private EntregaServico entregaServico;
	
	@RabbitListener(queues = {"${queue.entrega.nome}"})
	public void consultarFilaEntrega(@Payload Entrega entrega) {
		entregaServico.insert(entrega);
		System.out.println("Pedido: " + entrega.getId() + " Endereço de Entrega: " + entrega.getEndereco());
	}
}