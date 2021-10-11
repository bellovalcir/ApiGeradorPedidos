package com.bello.pedido.controles;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bello.pedido.entidades.Cliente;
import com.bello.pedido.servicos.ClienteServico;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteControle {
	
	@Autowired
	private ClienteServico clienteServico;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> list = clienteServico.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id){
		Cliente cliente = clienteServico.findById(id);
		return ResponseEntity.ok().body(cliente);		
	}
	
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente){
		cliente = clienteServico.insert(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(cliente);
	}
}