package com.bello.pedido.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class MonitorFilaEntregaConfig {
	
	public static void main(String[] args) {
        SpringApplication.run(MonitorFilaEntregaConfig.class, args);
    }
}