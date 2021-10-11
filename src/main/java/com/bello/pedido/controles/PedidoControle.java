package com.bello.pedido.controles;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bello.pedido.entidades.Pedido;
import com.bello.pedido.servicos.PedidoServico;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoControle {
	
	@Autowired
	private PedidoServico pedidoServico;
	
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll() {
		List<Pedido> list = pedidoServico.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id){
		Pedido pedido = pedidoServico.findById(id);
		return ResponseEntity.ok().body(pedido);		
	}
	
	@PostMapping
	public ResponseEntity<String> gerarPedido(@RequestBody Pedido pedido){
			
		pedidoServico.insert(pedido);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getId()).toUri();
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}