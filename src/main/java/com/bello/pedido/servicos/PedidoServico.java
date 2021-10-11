package com.bello.pedido.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bello.pedido.entidades.Pedido;
import com.bello.pedido.entidades.PedidoItens;
import com.bello.pedido.entidades.Produto;
import com.bello.pedido.repositorios.PedidoItensRepositorio;
import com.bello.pedido.repositorios.PedidoRepositorio;

@Service
public class PedidoServico {
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Autowired
	private PedidoItensRepositorio pedidoItensRepositorio;
	
	@Autowired
//	private EntregaServico entregaServico;
	
	
	public List<Pedido> findAll() {
		return pedidoRepositorio.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj = pedidoRepositorio.findById(id);
		return obj.get();		
	}
	
	public Pedido insert(Pedido pedido) {
		
		ArrayList<Produto> listaProduto = new ArrayList<>();
			
		for (PedidoItens p : pedido.getItems()) {
			listaProduto.add(p.getProduto());
		}		
		
		pedido = pedidoRepositorio.save(pedido);
		
		for (Produto prod : listaProduto) {
			PedidoItens pedidoItens = new PedidoItens(pedido, prod, prod.getValor());
			pedidoItensRepositorio.save(pedidoItens);
		}
			
		return pedido;
	}
}