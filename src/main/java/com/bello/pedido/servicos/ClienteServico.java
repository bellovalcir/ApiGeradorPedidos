package com.bello.pedido.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bello.pedido.entidades.Cliente;
import com.bello.pedido.repositorios.ClienteRepositorio;

@Service
public class ClienteServico {

	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	public List<Cliente> findAll() {
		return clienteRepositorio.findAll();
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> cliente = clienteRepositorio.findById(id);
		return cliente.get();		
	}
	
	public Cliente insert(Cliente cliente) {
		return clienteRepositorio.save(cliente);
	}
}