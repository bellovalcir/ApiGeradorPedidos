package com.bello.pedido.servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bello.pedido.entidades.Cliente;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class ClienteServicoTest {
	
	@Autowired
	private ClienteServico clienteServico;
	
	@Test
	public void findByIdTest() {
		
		Cliente cliente = clienteServico.findById(1L);
		
		assertEquals("Valcir", cliente.getNome());
		
	}
}