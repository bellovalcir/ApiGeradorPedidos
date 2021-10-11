package com.bello.pedido.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bello.pedido.entidades.Entrega;

@Component
public class EnviarFilaEntrega {
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
 
    @Autowired
    private Queue queue;
 
    public void send(Entrega entrega) {
        this.rabbitTemplate.convertAndSend(this.queue.getName(), entrega);
    }
}