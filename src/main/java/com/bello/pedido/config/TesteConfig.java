package com.bello.pedido.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bello.pedido.entidades.Cliente;
import com.bello.pedido.entidades.Produto;
import com.bello.pedido.repositorios.ClienteRepositorio;
import com.bello.pedido.repositorios.ProdutoRepositorio;

@Configuration
@Profile("teste")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	@Override
	public void run(String... args) throws Exception {
		
		Cliente c1 = new Cliente(null, "Valcir");
		Cliente c2 = new Cliente(null, "Paulo");
		
		clienteRepositorio.saveAll(Arrays.asList(c1, c2));
		
		Produto p1 = new Produto(null, "Monitor", 600.00);
		Produto p2 = new Produto(null, "Notebook", 1200.00);
		
		produtoRepositorio.saveAll(Arrays.asList(p1, p2));	
	}
}