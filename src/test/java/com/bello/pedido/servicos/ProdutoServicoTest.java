package com.bello.pedido.servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bello.pedido.entidades.Produto;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class ProdutoServicoTest {
	
	@Autowired
	private ProdutoServico produtoServico;
	
	@Test
	public void findByIdTest() {
		
		Produto produto = produtoServico.findById(1L);
		
		assertEquals("Monitor", produto.getNome());
		
	}

}
