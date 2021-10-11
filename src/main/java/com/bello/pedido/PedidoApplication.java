package com.bello.pedido;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PedidoApplication {
	
	@Value("${queue.entrega.nome}")
    private String entregaFila;
	
	public static void main(String[] args) {
		SpringApplication.run(PedidoApplication.class, args);
	}
	
	@Bean
    public Queue queue() {
        return new Queue(entregaFila, true, false, false);
    }

}